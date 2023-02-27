package com.vnazarov.krokkrefactored.utilits.vm

import com.vnazarov.krokkrefactored.objects.City
import com.vnazarov.krokkrefactored.utilits.BaseViewModel
import com.vnazarov.krokkrefactored.utilits.helpers.LANGUAGE
import com.vnazarov.krokkrefactored.utilits.helpers.REGION

class CitiesViewModel: BaseViewModel() {

    private var citiesUnProcessed = arrayListOf<City>()

    fun initializeCities(): ArrayList<City> {
        val indexedCities = arrayListOf<City>()

        for (i in citiesUnProcessed) {
            if (i.language == LANGUAGE && i.cityRegion == REGION && i.isCityVisible) indexedCities.add(i)
        }

        return indexedCities
    }

    fun setCities(cities: ArrayList<City>){
        if (citiesUnProcessed.isEmpty()) citiesUnProcessed = cities
    }
}