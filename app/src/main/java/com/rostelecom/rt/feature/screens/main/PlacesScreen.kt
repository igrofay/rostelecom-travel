package com.rostelecom.rt.feature.screens.main


import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
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
import com.rostelecom.rt.ui.widgets.ButtonCity
import com.rostelecom.rt.ui.widgets.ButtonPlace
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun PlacesScreen(model: ViewModelMain) {
    val list = model.listCity
    val navHostController = rememberNavController()
    NavHost(navHostController , NavigationRoute.Main.Places.Cities.route){
        composable(NavigationRoute.Main.Places.Cities.route){ list?.let { it1 -> CitiesScreen(it1 , navHostController ) } }
        composable(NavigationRoute.Main.Places.CityPlaces.route, arguments = listOf(navArgument("id") { type = NavType.IntType })){ backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            val city = list?.get(id)
            CityPlacesScreen(city!!, model)
        }
    }

}

@Composable
fun CitiesScreen(list: List<City>, navHost : NavHostController) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(list){
            ButtonCity(it.name ,
                it.imagePath)
            {
                if(it.placesList == null){
                    WorkWithRetrofit.server.getCityPlaces(it.id).enqueue(object : Callback<List<Place>>{
                        override fun onResponse(
                            call: Call<List<Place>>,
                            response: Response<List<Place>>
                        ) {
                            it.placesList = response.body() ?: listOf()
                            Log.e("tt", response.body()?.size.toString())

                            navHost.navigate("city_places/${it.id}")
                        }
                        override fun onFailure(call: Call<List<Place>>, t: Throwable) {
                            Log.e("tt", t.message.toString())
                        }
                    })
                }else{
                    navHost.navigate("city_places/${it.id}")
                }
            }
        }
    }
}

@Composable
fun CityPlacesScreen(city: City, model: ViewModelMain) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(city.placesList!!) {
            ButtonPlace(it , true)
        }
    }
}



