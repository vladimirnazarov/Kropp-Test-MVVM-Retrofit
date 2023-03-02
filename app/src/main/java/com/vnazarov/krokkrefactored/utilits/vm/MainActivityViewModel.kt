package com.vnazarov.krokkrefactored.utilits.vm

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vnazarov.krokkrefactored.objects.City
import com.vnazarov.krokkrefactored.objects.Place
import com.vnazarov.krokkrefactored.utilits.retrofit.`interface`.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    private val cities = MutableLiveData<MutableList<City>>()
    private val places = MutableLiveData<MutableList<Place>>()
    private lateinit var mService: RetrofitServices

    private fun downloadCities(context: Context, onSuccess: () -> Unit) {
        mService.getCities().enqueue(object : Callback<MutableList<City>> {
            override fun onResponse(
                call: Call<MutableList<City>>,
                response: Response<MutableList<City>>
            ) {
                cities.value = response.body()
                if (cities.value == null){
                    Toast.makeText(context, "Bad gateway", Toast.LENGTH_SHORT).show()
                } else onSuccess()
            }

            override fun onFailure(call: Call<MutableList<City>>, t: Throwable) {
            }
        })
    }

    private fun downloadPlaces(context: Context, onSuccess: () -> Unit) {
        mService.getPlaces().enqueue(object : Callback<MutableList<Place>> {
            override fun onResponse(
                call: Call<MutableList<Place>>,
                response: Response<MutableList<Place>>
            ) {
                places.value = response.body()
                if (places.value == null){
                    Toast.makeText(context, "Bad gateway", Toast.LENGTH_SHORT).show()
                } else onSuccess()
            }

            override fun onFailure(call: Call<MutableList<Place>>, t: Throwable) {
                Log.e("Error: ", t.message!!)
            }
        })
    }

    fun loadData(context: Context, onSuccess: () -> Unit) {
        if (cities.value == null) {
            downloadCities(context) {
                downloadPlaces(context) {
                    onSuccess()
                }
            }
        } else {
            downloadPlaces(context) {
                onSuccess()
            }
        }
    }

    fun getCities() = cities.value

    fun getPlaces() = places.value

    fun setService(mService: RetrofitServices) {
        this.mService = mService
    }
}