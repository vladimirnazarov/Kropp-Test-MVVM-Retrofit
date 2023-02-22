package com.vnazarov.krokkrefactored.utilits.adapters

import com.vnazarov.krokkrefactored.objects.Place
import com.vnazarov.krokkrefactored.utilits.BaseAdapter
import com.vnazarov.krokkrefactored.utilits.BaseViewModel

class PlacesAdapter(list: List<Place>, viewModel: BaseViewModel, address: Int) :
    BaseAdapter(list, viewModel, address) {}