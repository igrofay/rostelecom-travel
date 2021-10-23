package com.rostelecom.rt.module

import com.rostelecom.rt.data.City
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServerApi {
    @GET("city")
    fun getListCity() : Call<List<City>>
}