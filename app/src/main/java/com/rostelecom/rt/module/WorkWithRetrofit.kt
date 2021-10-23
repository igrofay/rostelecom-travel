package com.rostelecom.rt.module

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WorkWithRetrofit {
    private const val MAIN_URL = "http://192.168.127.50:8080/"
    private val retrofitInstance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(MAIN_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val server : ServerApi by lazy {
        retrofitInstance.create(ServerApi::class.java)
    }
}