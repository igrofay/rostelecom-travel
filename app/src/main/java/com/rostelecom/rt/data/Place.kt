package com.rostelecom.rt.data

data class Place(val id : Int, val name : String,
                 val imagePath : String, val address : String,
                 val type : String, var favorite : Boolean = false )
