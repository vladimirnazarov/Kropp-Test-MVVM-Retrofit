package com.vnazarov.krokkrefactored.utilits.retrofit.`interface`

import com.vnazarov.krokkrefactored.objects.City
import com.vnazarov.krokkrefactored.objects.Place
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {

    @GET("get_cities/11/")
    fun getCities(): Call<MutableList<City>>

    @GET("get_points/11/")
    fun getPlaces(): Call<MutableList<Place>>
}