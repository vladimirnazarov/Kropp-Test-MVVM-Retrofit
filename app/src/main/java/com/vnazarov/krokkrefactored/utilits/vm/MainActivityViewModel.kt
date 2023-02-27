package com.vnazarov.krokkrefactored.utilits.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vnazarov.krokkrefactored.objects.City
import com.vnazarov.krokkrefactored.utilits.retrofit.`interface`.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel: ViewModel() {

    private val cities = MutableLiveData<MutableList<City>>()

    fun downloadCities(mService: RetrofitServices) {
        mService.getCities().enqueue(object : Callback<MutableList<City>> {
            override fun onResponse(call: Call<MutableList<City>>, response: Response<MutableList<City>>) {
                cities.value = response.body()
            }

            override fun onFailure(call: Call<MutableList<City>>, t: Throwable) {
            }

        })
    }

    fun getCities() = cities.value
}