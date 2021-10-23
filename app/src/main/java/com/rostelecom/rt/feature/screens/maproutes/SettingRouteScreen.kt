package com.rostelecom.rt.feature.screens.maproutes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.rostelecom.rt.R
import com.rostelecom.rt.ui.theme.Black900
import com.rostelecom.rt.ui.widgets.DateDialog
import com.rostelecom.rt.ui.widgets.DropDownSelect
import com.rostelecom.rt.ui.widgets.EditText
import com.rostelecom.rt.ui.widgets.EditTextBasic
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState

@Composable
fun SettingRouteScreen() {
    var budget by remember { mutableStateOf("") }
    val hashMapTransport = hashMapOf("Машина" to false , "Автобус" to false , "Авиаперелет" to false , "Ж/Д" to false , "Такси" to false)
    LazyColumn(Modifier.fillMaxSize(), contentPadding = PaddingValues(horizontal = 18.dp, vertical = 14.dp), verticalArrangement = Arrangement.spacedBy(12.dp)){
        item { AtoB() }
        item { DropDownSelect(R.string.transport,
            stringIsState = hashMapTransport ) }
        item { EditText( R.drawable.ic_money , R.string.budget, KeyboardType.Number , budget , newInput = {budget = it} ) }
        item {  }
    }


}

@Composable
fun AtoB() {
    var placesStart by remember{
        mutableStateOf("")
    }
    var placesEnd by remember{
        mutableStateOf("")
    }
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
                EditTextBasic(placesStart, R.string.is_from ){ placesStart = it }
            }
            Row(
                Modifier
                    .padding(12.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Icon(painterResource(R.drawable.ic_to_where), contentDescription = null )
                EditTextBasic( placesEnd, R.string.to_where ){  placesEnd= it }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DateWidget() {
    var v by remember { mutableStateOf("") }
    Surface(
        onClick ={
                 
        },
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp , Black900),
        color = MaterialTheme.colors.surface
    ) {
        Row(Modifier.fillMaxWidth()) {

        }
    }
}