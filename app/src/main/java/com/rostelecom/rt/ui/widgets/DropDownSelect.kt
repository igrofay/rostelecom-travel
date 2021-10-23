package com.rostelecom.rt.ui.widgets

import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rostelecom.rt.R
import com.rostelecom.rt.ui.theme.Black900
import com.rostelecom.rt.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropDownSelectCheckBox(
    @StringRes titleSelect : Int , stringIsState : HashMap<String , Boolean>
) {
    var expandedState by remember { mutableStateOf(true) }
    val rotationState by animateFloatAsState(
        if(expandedState) 180f else 0f
    )
    Card(modifier = Modifier
        .fillMaxWidth()
        .animateContentSize(
            animationSpec = tween(easing = LinearOutSlowInEasing)
        ),  shape = Shapes.medium, border = BorderStroke(1.dp , Black900)  ,
        onClick = { expandedState = !expandedState}) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(stringResource(titleSelect), fontWeight = FontWeight.Bold, style = MaterialTheme.typography.h6, modifier = Modifier.weight(1f), maxLines = 1 )
                Icon(Icons.Default.ArrowDropDown, contentDescription = null , Modifier.rotate(rotationState))
            }
            if(expandedState){
                Spacer(Modifier.height(8.dp))
                stringIsState.forEach { (string, bool) ->
                    Spacer(Modifier.height(10.dp))
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Text(string, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.h6, modifier = Modifier.weight(1f), maxLines = 1 )
                        var values by remember { mutableStateOf(bool)}
                        Checkbox(checked = values,
                            onCheckedChange = {
                                stringIsState[string] = it
                                values = it
                            })
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropDownSelectCount(
    @StringRes titleSelect : Int , stringIsState : HashMap<String , Int>
) {
    var expandedState by remember { mutableStateOf(true) }
    val rotationState by animateFloatAsState(
        if(expandedState) 180f else 0f
    )
    Card(modifier = Modifier
        .fillMaxWidth()
        .animateContentSize(
            animationSpec = tween(easing = LinearOutSlowInEasing)
        ),  shape = Shapes.medium, border = BorderStroke(1.dp , Black900)  ,
        onClick = { expandedState = !expandedState}) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(stringResource(titleSelect), fontWeight = FontWeight.Bold, style = MaterialTheme.typography.h6, modifier = Modifier.weight(1f), maxLines = 1 )
                Icon(Icons.Default.ArrowDropDown, contentDescription = null , Modifier.rotate(rotationState))
            }
            if(expandedState){
                Spacer(Modifier.height(8.dp))
                stringIsState.forEach { (string, count) ->
                    Spacer(Modifier.height(10.dp))
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Text(string, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.h6, modifier = Modifier.weight(5f), maxLines = 1 )
                        var values by remember { mutableStateOf(count)}
                        Button(onClick = {
                            values++
                            stringIsState[string]?.let {
                                stringIsState[string] = it+1
                            }
                        }, modifier = Modifier.weight(1f)) {
                            Text("+", Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                        }
                        Text(values.toString(), modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                        Button(onClick = {
                            values--
                            stringIsState[string]?.let {
                                stringIsState[string] = it-1
                            }
                                         } , enabled = values>0 , modifier = Modifier.weight(1f)) {
                            Text("-", Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                        }
                    }
                }
            }
        }
    }
}
