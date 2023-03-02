package com.vnazarov.krokkrefactored.utilits.vm

import com.vnazarov.krokkrefactored.objects.Place
import com.vnazarov.krokkrefactored.utilits.BaseViewModel

class PlacesViewModel: BaseViewModel() {

    private var placesUnProcessed = arrayListOf<Place>()
    private var currentLanguage = 0
    private var currentCity = 0

    fun initializePlaces(): ArrayList<Place> {
        val indexedPlaces = arrayListOf<Place>()

        for (i in placesUnProcessed){
            if (i.language == currentLanguage && i.isVisible && i.cityId == currentCity) indexedPlaces.add(i)
        }

        return indexedPlaces
    }

    fun setPlaces(places: ArrayList<Place>){
        if (placesUnProcessed.isEmpty()) placesUnProcessed = places
    }

    fun setLanguage(language: Int?){
        if (language != null){
            currentLanguage = language
        }
    }

    fun setCity(city: Int?){
        if (city != null){
            currentCity = city
        }
    }
}