package com.vnazarov.krokkrefactored.utilits.vm

import android.content.Context
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

    private fun downloadCities(
        context: Context,
        onSuccess: () -> Unit,
        onFail: () -> Unit,
        onWait: () -> Unit
    ) {
        onWait()
        mService.getCities().enqueue(object : Callback<MutableList<City>> {
            override fun onResponse(
                call: Call<MutableList<City>>,
                response: Response<MutableList<City>>
            ) {
                cities.value = response.body()
                if (cities.value == null) {
                    onFail()
                    Toast.makeText(context, "Bad gateway", Toast.LENGTH_SHORT).show()
                } else onSuccess()
            }

            override fun onFailure(call: Call<MutableList<City>>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                onFail()
            }
        })
    }

    private fun downloadPlaces(
        context: Context,
        onSuccess: () -> Unit,
        onFail: () -> Unit,
        onWait: () -> Unit
    ) {
        onWait()
        mService.getPlaces().enqueue(object : Callback<MutableList<Place>> {
            override fun onResponse(
                call: Call<MutableList<Place>>,
                response: Response<MutableList<Place>>
            ) {
                places.value = response.body()
                if (places.value == null) {
                    onFail()
                    Toast.makeText(context, "Bad gateway", Toast.LENGTH_SHORT).show()
                } else onSuccess()
            }

            override fun onFailure(call: Call<MutableList<Place>>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                onFail()
            }
        })
    }

    fun loadData(context: Context, onSuccess: () -> Unit, onFail: () -> Unit, onWait: () -> Unit) {
        if (cities.value == null) {

            downloadCities(context, {
                downloadPlaces(context, {
                    onSuccess()
                }, {
                    onFail()
                }, {
                    onWait()
                })
            }, {
                onFail()
            }, {
                onWait()
            })

        } else {
            downloadPlaces(context, {
                onSuccess()
            }, {
                onFail()
            }, {
                onWait()
            })
        }
    }

    fun getCities() = cities.value

    fun getPlaces() = places.value

    fun setService(mService: RetrofitServices) {
        this.mService = mService
    }
}