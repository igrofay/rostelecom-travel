package com.rostelecom.rt.feature.screens.maproutes

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.rostelecom.rt.R
import com.rostelecom.rt.ui.theme.Black900
import com.rostelecom.rt.ui.widgets.*
import java.time.LocalDate

@Composable
fun CreateRouteScreen() {
    var startRoute by rememberSaveable{ mutableStateOf("") }
    var endRoute by rememberSaveable{ mutableStateOf("") }
    var budget by rememberSaveable{ mutableStateOf("") }
    val hashMapTransport = rememberSaveable{ hashMapOf("Машина" to false , "Автобус" to false , "Авиаперелет" to false , "Ж/Д" to false , "Такси" to false)}
    var dateStartTravel by rememberSaveable { mutableStateOf("") }
    var dateEndTravel by rememberSaveable { mutableStateOf("") }
    val hashMapPeople = rememberSaveable{ hashMapOf("Взрослые" to 0 , "Дети" to 0 , "Инвалиды" to 0 ) }
    LazyColumn(Modifier.fillMaxSize(), contentPadding = PaddingValues(horizontal = 18.dp, vertical = 14.dp), verticalArrangement = Arrangement.spacedBy(12.dp)){
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