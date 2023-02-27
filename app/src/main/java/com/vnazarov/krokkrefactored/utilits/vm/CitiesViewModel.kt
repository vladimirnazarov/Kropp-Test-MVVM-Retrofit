package com.vnazarov.krokkrefactored.utilits.vm

import com.vnazarov.krokkrefactored.objects.City
import com.vnazarov.krokkrefactored.utilits.BaseViewModel

class CitiesViewModel: BaseViewModel() {

    private var citiesUnProcessed = arrayListOf<City>()
    private var currentRegion = ""
    private var currentLanguage = 0

    fun initializeCities(): ArrayList<City> {
        val indexedCities = arrayListOf<City>()

        for (i in citiesUnProcessed) {
            if (i.language == currentLanguage && i.cityRegion == currentRegion && i.isCityVisible) indexedCities.add(i)
        }

        return indexedCities
    }

    fun setCities(cities: ArrayList<City>){
        if (citiesUnProcessed.isEmpty()) citiesUnProcessed = cities
    }

    fun setRegions(region: String?){
        if (region != null) {
            currentRegion = region
        }
    }

    fun setLanguage(language: Int?){
        if (language != null){
            currentLanguage = language
        }
    }
}