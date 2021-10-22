package com.rostelecom.rt.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF9466FF)
val Purple700 = Color(0xFF7700FF)
val Orange500 = Color(0xFFFF5E2D)
val Orange700 = Color(0xFFFF4F12)
val Teal500 = Color(0xFF16D9A6)
val Teal700 = Color(0xFF29CCA3)
val Gray200 = Color(0xFFE8E8EE)
val Gray500 = Color(0xFF3D4555)

val Colors.Orange: Color
    get() = if (isLight) Orange700 else Orange500
