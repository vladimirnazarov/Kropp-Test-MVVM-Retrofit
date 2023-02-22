package com.vnazarov.krokkrefactored.utilits.vm

import com.vnazarov.krokkrefactored.objects.City
import com.vnazarov.krokkrefactored.utilits.BaseViewModel

class CitiesViewModel: BaseViewModel() {

    fun initializeCities(): ArrayList<City> {
        val array = arrayListOf<City>()

        for (i in 1..10) {
            val city = City(cityName = "City test $i")
            array.add(city)
        }

        return array
    }
}