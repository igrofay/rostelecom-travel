package com.rostelecom.rt.data

data class City(
    val id: Int, val name : String ,
    val imagePath :  String , var placesList: List<Place>? = null
    )
