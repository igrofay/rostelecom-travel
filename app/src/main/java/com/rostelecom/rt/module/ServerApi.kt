package com.rostelecom.rt.module

import com.rostelecom.rt.data.City
import com.rostelecom.rt.data.Place
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServerApi {
    @GET("doc612755537_613879669?hash=fd52098999f9e0a6f2&dl=99d37e913d56151f7b")
    fun getListCity() : Call<List<City>>
    @GET("city/{id}")
    fun getCityPlaces(@Query("id") id :Int ): Call<List<Place>>
}