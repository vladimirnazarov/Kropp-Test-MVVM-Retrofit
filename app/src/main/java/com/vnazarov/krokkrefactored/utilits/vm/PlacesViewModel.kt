package com.vnazarov.krokkrefactored.utilits.vm

import com.vnazarov.krokkrefactored.objects.Place
import com.vnazarov.krokkrefactored.utilits.BaseViewModel

class PlacesViewModel: BaseViewModel() {

    fun initializePlaces(): ArrayList<Place> {
        val array = arrayListOf<Place>()

        for (i in 1..5) {
            val place = Place(name = "Place test $i")
            array.add(place)
        }

        return array
    }
}