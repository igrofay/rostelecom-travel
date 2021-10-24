package com.rostelecom.rt.data

data class Travel(
    var id : Int,
    var  startRoute : String ,
    var endRoute : String,
    var budget : String ,
    var hashMapTransport :  HashMap<String, Boolean>,
    var  dateStartTravel : String,
    var dateEndTravel : String,
    var hashMapPeople : HashMap<String, Int>,
    var placesList: List<Place>
)
