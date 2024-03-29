package com.rostelecom.rt.feature.main

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import com.rostelecom.rt.data.City
import com.rostelecom.rt.feature.navigation.NavigationAppRT
import com.rostelecom.rt.feature.navigation.NavigationRoute
import com.rostelecom.rt.module.WorkWithRetrofit
import com.rostelecom.rt.ui.theme.RTTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    private val model: ViewModelMain by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
        ActivityCompat.requestPermissions(this, permissions,0)


        setContent {
            RTTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navHost = rememberNavController()
                    model.isScreen.observe(this){
                        if(it==-1) return@observe
                        navHost.navigate(NavigationRoute.Main.route){
                            popUpTo(NavigationRoute.Welcome.route){ inclusive = true }
                        }
                    }
                    NavigationAppRT(navHost , model)
                }
            }
        }
    }
}
