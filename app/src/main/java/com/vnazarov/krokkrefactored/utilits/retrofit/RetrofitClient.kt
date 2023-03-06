package com.vnazarov.krokkrefactored.utilits.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private var retrofit: Retrofit? = null
    private var httpClient: OkHttpClient.Builder? = null

    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null && httpClient == null){

            httpClient = OkHttpClient.Builder()
                .callTimeout(2, TimeUnit.MINUTES)
                .connectTimeout(300, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS)
                .writeTimeout(300, TimeUnit.SECONDS)

            val retrofitBuilder = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient!!.build())

            retrofit = retrofitBuilder.build()
        }

        return retrofit!!
    }
}