package com.vnazarov.krokkrefactored.objects

import com.google.gson.annotations.SerializedName

data class City(

    @SerializedName("id_locale")
    val locationId: Int = 0,

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("name")
    val cityName: String = "",

    @SerializedName("lang")
    val language: Int = 0,

    @SerializedName("logo")
    val cityEmblem: String = "",

    @SerializedName("last_edit_time")
    val lastEditTime: Long = 0,

    @SerializedName("visible")
    val isCityVisible: Boolean = false,

    @SerializedName("city_is_regional")
    val isCityRegional: Boolean = false,

    @SerializedName("region")
    val cityRegion: String = ""
)
