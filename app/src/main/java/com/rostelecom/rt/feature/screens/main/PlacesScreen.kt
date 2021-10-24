package com.rostelecom.rt.feature.screens.main


import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rostelecom.rt.data.City
import com.rostelecom.rt.data.Place
import com.rostelecom.rt.feature.main.ViewModelMain
import com.rostelecom.rt.feature.navigation.NavigationRoute
import com.rostelecom.rt.module.WorkWithRetrofit
import com.rostelecom.rt.ui.widgets.ButtonPlaces
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun PlacesScreen(model: ViewModelMain) {
    val list = model.listCity
    val navHostController = rememberNavController()
    NavHost(navHostController , NavigationRoute.Main.Places.Cities.route){
        composable(NavigationRoute.Main.Places.Cities.route){ list?.let { it1 -> CitiesScreen(it1) } }
        composable(NavigationRoute.Main.Places.CityPlaces.route, arguments = listOf(navArgument("id") { type = NavType.IntType })){ backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            val city = list?.get(id)
            var state by remember { mutableStateOf(false) }
            city?.placesList?.let {
                state = true
            } ?:
            WorkWithRetrofit.server.getCityPlaces(id).enqueue(object : Callback<List<Place>>{
                override fun onResponse(call: Call<List<Place>>, response: Response<List<Place>>) {
                    city?.placesList = response.body()!!
                    state = true
                }

                override fun onFailure(call: Call<List<Place>>, t: Throwable) {
                    Log.e("err" , t.message.toString())
                }

            })
            if(state){
                CityPlacesScreen(city!!)
            }
        }
    }

}

@Composable
fun CitiesScreen(list: List<City>) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(list){
            ButtonPlaces(it.name ,
                it.imagePath){}
        }
    }
}

@Composable
fun CityPlacesScreen(city: City) {

}