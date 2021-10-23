package com.rostelecom.rt.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.rostelecom.rt.feature.navigation.NavigationAppRT
import com.rostelecom.rt.ui.theme.RTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RTTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navHost = rememberNavController()
                    NavigationAppRT(navHost)
                }
            }
        }
    }
}
