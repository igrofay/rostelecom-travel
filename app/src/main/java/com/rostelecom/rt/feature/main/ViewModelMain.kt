package com.rostelecom.rt.feature.main

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.rostelecom.rt.data.City
import com.rostelecom.rt.data.Place
import com.rostelecom.rt.module.WorkWithRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread


class ViewModelMain : ViewModel() {
    var listCity : List<City>? = null
    init {
        WorkWithRetrofit.server.getListCity().enqueue(object : Callback<List<City>> {
            override fun onResponse(call: Call<List<City>>, response: Response<List<City>>) {
                listCity = response.body()
                Log.e("err" , "1")
            }

            override fun onFailure(call: Call<List<City>>, t: Throwable) {
                Log.e("rr", t.message.toString())
            }
        })
    }
    fun listBookmakers() : List<Place> {
        val list = mutableListOf<Place>()
        listCity?.forEach {
            it.placesList?.forEach {  place ->
                if (place.favorite) list.add(place)
            }
        }
        return list
    }
    var mainRoute : List<List<Double>>? = null
}