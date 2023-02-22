package com.vnazarov.krokkrefactored.utilits.adapters

import com.vnazarov.krokkrefactored.objects.City
import com.vnazarov.krokkrefactored.utilits.BaseAdapter
import com.vnazarov.krokkrefactored.utilits.vm.CitiesViewModel

class CitiesAdapter(
    list: List<City>,
    viewModel: CitiesViewModel,
    address: Int
) : BaseAdapter(list, viewModel, address)
