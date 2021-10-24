package com.rostelecom.rt.module

import com.rostelecom.rt.data.City
import com.rostelecom.rt.data.Place
import com.rostelecom.rt.data.Travel
import retrofit2.Call
import retrofit2.http.*

interface ServerApi {
    @GET("/city")
    fun getListCity() : Call<List<City>>
    @GET("/city/{id}")
    fun getCityPlaces(@Path("id") id : Int ): Call<List<Place>>
    @POST("users/route")
    fun createRouteTravel(@Body travel: Travel) : Call<List<List<Double> >>
}