package com.vnazarov.krokkrefactored.utilits.adapters

import com.vnazarov.krokkrefactored.objects.Region
import com.vnazarov.krokkrefactored.utilits.BaseAdapter
import com.vnazarov.krokkrefactored.utilits.BaseViewModel

class RegionsAdapter(
    list: List<Region>,
    viewModel: BaseViewModel,
    address: Int
) : BaseAdapter(list, viewModel, address)