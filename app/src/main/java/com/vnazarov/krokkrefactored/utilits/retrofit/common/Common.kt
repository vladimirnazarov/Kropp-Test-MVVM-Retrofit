package com.vnazarov.krokkrefactored.utilits.retrofit.common

import com.vnazarov.krokkrefactored.utilits.retrofit.RetrofitClient
import com.vnazarov.krokkrefactored.utilits.retrofit.`interface`.RetrofitServices

object Common {

    private val BASE_URL = "http://krokapp.by/api/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}