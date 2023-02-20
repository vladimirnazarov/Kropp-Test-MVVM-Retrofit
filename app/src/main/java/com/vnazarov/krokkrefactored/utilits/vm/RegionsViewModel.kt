package com.vnazarov.krokkrefactored.utilits.vm

import com.vnazarov.krokkrefactored.databinding.RegionItemBinding
import com.vnazarov.krokkrefactored.objects.Region
import com.vnazarov.krokkrefactored.utilits.BaseViewModel

class RegionsViewModel : BaseViewModel() {

    fun initializeRegions(): ArrayList<Region> {
        val array = arrayListOf<Region>()

        for (i in 1..6) {
            val region = Region("Region test $i")
            array.add(region)
        }

        return array
    }

    fun onBindRegion(binding: RegionItemBinding, name: String, address: Int){
        binding.regionItemName.text = name

        binding.regionFullItem.isClickable = true
        binding.regionFullItem.setOnClickListener {
            navigateTo(address, fromName = name)
        }
    }
}