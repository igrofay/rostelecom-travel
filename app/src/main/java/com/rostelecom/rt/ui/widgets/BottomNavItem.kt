package com.rostelecom.rt.ui.widgets

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rostelecom.rt.ui.theme.WhileOrBlack
import com.rostelecom.rt.ui.theme.Orange

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RowScope.BottomNavItem(selected: Boolean,
                  onClick: () -> Unit,
                  @DrawableRes iconRes:  Int,
                  @StringRes labelRes: Int
) {
    val background = if (selected) MaterialTheme.colors.Orange.copy(0.2f) else Color.Transparent
    val contentColor = if(selected) MaterialTheme.colors.Orange else MaterialTheme.colors.WhileOrBlack
    Box(
        Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ){
        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            Icon(painterResource(iconRes), contentDescription = null, tint = contentColor )
            AnimatedVisibility(visible = selected) {
                Text(
                    stringResource(labelRes),
                    color = contentColor
                )
            }
        }
    }
}