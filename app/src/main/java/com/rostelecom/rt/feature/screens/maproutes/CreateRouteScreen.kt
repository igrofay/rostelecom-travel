package com.rostelecom.rt.feature.screens.maproutes

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.rostelecom.rt.R
import com.rostelecom.rt.data.Place
import com.rostelecom.rt.data.Travel
import com.rostelecom.rt.feature.main.ViewModelMain
import com.rostelecom.rt.feature.navigation.NavigationRoute
import com.rostelecom.rt.module.WorkWithRetrofit
import com.rostelecom.rt.ui.theme.Black900
import com.rostelecom.rt.ui.widgets.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate

@Composable
fun CreateRouteScreen(navMap : NavController , model: ViewModelMain) {
    var startRoute by rememberSaveable{ mutableStateOf("") }
    var endRoute by rememberSaveable{ mutableStateOf("") }
    var budget by rememberSaveable{ mutableStateOf("") }
    val hashMapTransport = rememberSaveable{ hashMapOf("Машина" to false , "Автобус" to false , "Авиаперелет" to false , "Ж/Д" to false , "Такси" to false)}
    var dateStartTravel by rememberSaveable { mutableStateOf("") }
    var dateEndTravel by rememberSaveable { mutableStateOf("") }
    val hashMapPeople = rememberSaveable{ hashMapOf("Взрослые" to 0 , "Дети" to 0 , "PWD" to 0 ) }
    val listPlaces =  mutableListOf<Place>()
    val listFavouritePlace = model.listBookmakers()



    val listState = rememberLazyListState()
    val showButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex <= 0
        }
    }
    Box(Modifier.fillMaxSize()){
        LazyColumn(Modifier.fillMaxSize(), contentPadding = PaddingValues(horizontal = 18.dp, vertical = 14.dp), verticalArrangement = Arrangement.spacedBy(12.dp),
            state = listState
        ){
            item { AtoB(startRoute, endRoute , { startRoute = it } , { endRoute = it} ) }
            item { DropDownSelectCheckBox(R.string.transport,
                stringIsState = hashMapTransport ) }
            item { EditText( R.drawable.ic_money , R.string.budget, KeyboardType.Number , budget , newInput = {budget = it}, Modifier.padding(vertical = 20.dp) ) }
            item { if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Card(Modifier.fillMaxWidth()){
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 6.dp)) {
                        DateWidget(R.string.start_travel, dateStartTravel ){ dateStartTravel = "${it.dayOfMonth}/${it.monthValue}/${it.year}"}
                        Divider()
                        DateWidget(R.string.end_travel, dateEndTravel ){ dateEndTravel = "${it.dayOfMonth}/${it.monthValue}/${it.year}"}
                    }
                }

            } }
            item { DropDownSelectCount(R.string.people, hashMapPeople ) }
            if(listFavouritePlace.isNotEmpty()) item {
                Text("Закладки", Modifier.fillMaxWidth(), textAlign = TextAlign.Center , fontSize= MaterialTheme.typography.h6.fontSize , fontWeight = FontWeight.W800 )
            }
            if(listFavouritePlace.isNotEmpty()) items(listFavouritePlace){
                UsePlace(it, listPlaces )
            }
        }
        AnimatedVisibility(visible = showButton,
            Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)) {
            FloatingActionButton(onClick = {
                Log.e("size" , listPlaces.size.toString())
                val travel = Travel(-1 , startRoute, endRoute , budget, hashMapTransport , dateStartTravel , dateEndTravel , hashMapPeople, listPlaces )
                WorkWithRetrofit.server.createRouteTravel(travel).enqueue(object : Callback<List<List<Double>>>{
                    override fun onResponse(
                        call: Call<List<List<Double>>>,
                        response: Response<List<List<Double>>>
                    ) {
                        model.mainRoute = response.body()
                        navMap.navigate(NavigationRoute.Main.MapRoutes.Map.route)
                    }

                    override fun onFailure(call: Call<List<List<Double>>>, t: Throwable) {

                    }

                })
            }) {
                Icon( Icons.Default.Build , null )
            }
        }
    }




}

@Composable
fun AtoB(placesStart : String , placesEnd : String ,
         inputPlacesStart : (str : String)-> Unit, inputPlacesEnd : (str : String)-> Unit) {

    Surface(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp , Black900),
        color = MaterialTheme.colors.surface
    ) {
        Column(
            Modifier
                .padding(16.dp)
                .fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
                Image(painterResource(R.drawable.ic_route), contentDescription = null , modifier = Modifier.size(40.dp))
                Spacer(Modifier.width(8.dp))
                Text(stringResource(R.string.where_going), style = MaterialTheme.typography.h5
                )
            }
            Spacer(Modifier.height(16.dp))
            Row(
                Modifier
                    .padding(12.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Icon(painterResource(R.drawable.ic_is_from), contentDescription = null )
                EditTextBasic(placesStart, R.string.is_from , inputPlacesStart)
            }
            Row(
                Modifier
                    .padding(12.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Icon(painterResource(R.drawable.ic_to_where), contentDescription = null )
                EditTextBasic( placesEnd, R.string.to_where, inputPlacesEnd)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DateWidget(@StringRes labelTravel : Int,
               dateTravel : String , newDateTravel:(date:LocalDate)-> Unit
               ) {

    var openDialog by remember { mutableStateOf(false) }

    Surface(
        onClick ={
                 openDialog = true
        },
        color = MaterialTheme.colors.surface, modifier = Modifier.fillMaxWidth()
    ) {
        Text(stringResource(labelTravel)+" "+ dateTravel , fontSize = MaterialTheme.typography.h6.fontSize )
    }

    if (openDialog){
        DateDialog(
            newDateTravel,
            {openDialog = false}
        )
    }
}

@Composable
fun UsePlace(place: Place, useList : MutableList<Place>) {

    var isAdd by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(
        if(isAdd) 45f else 0f
    )
    Box(contentAlignment = Alignment.Center , modifier = Modifier
        .fillMaxWidth().height(260.dp)){
        ButtonPlace(place , false)
        Box(Modifier
                .fillMaxWidth().height(260.dp).alpha(0.5f)
                .background(Black900))
        Icon(Icons.Default.Add, contentDescription = null  ,
            Modifier.shadow(5.dp ,RoundedCornerShape(50.dp)).size(60.dp).align(Alignment.Center)
                .clickable {
                    if (isAdd) {
                        useList.remove(place)
                    } else {
                        useList.add(place)
                    }
                    isAdd = !isAdd
                }
                .rotate(rotationState), tint = Color.White)

    }
}
