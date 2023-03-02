package com.vnazarov.krokkrefactored.objects

import com.google.gson.annotations.SerializedName

data class Place(

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("id_point")
    val pointId: Int = 0,

    @SerializedName("name")
    val name: String = "",

    @SerializedName("text")
    val text: String = "",

    @SerializedName("sound")
    val sound: String = "",

    @SerializedName("lang")
    val language: Int = 0,

    @SerializedName("last_edit_time")
    val lastEditTime: Long = 0,

    @SerializedName("creation_date")
    val creationDate: String = "",

    @SerializedName("lat")
    val latitude: Double = 0.0,

    @SerializedName("lng")
    val longitude: Double = 0.0,

    @SerializedName("logo")
    val logo: String = "",

    @SerializedName("photo")
    val photo: String = "",

    @SerializedName("city_id")
    val cityId: Int = 0,

    @SerializedName("visible")
    val isVisible: Boolean = false,

    @SerializedName("images")
    val images: List<String> = arrayListOf(),

    @SerializedName("tags")
    val tags: List<Int> = arrayListOf(),

    @SerializedName("is_excursion")
    val isExcursion: Boolean = false
)
