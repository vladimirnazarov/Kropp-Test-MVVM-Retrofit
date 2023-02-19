package com.vnazarov.krokkrefactored.fragments.cities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vnazarov.krokkrefactored.R
import com.vnazarov.krokkrefactored.databinding.CityItemBinding
import com.vnazarov.krokkrefactored.objects.City
import com.vnazarov.krokkrefactored.utilits.vm.CitiesViewModel

class CitiesAdapter(private val list: List<City>, private val viewModel: CitiesViewModel): RecyclerView.Adapter<CitiesAdapter.CitiesHolder>() {

    inner class CitiesHolder(val binding: CityItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesHolder {
        val binding = CityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CitiesHolder(binding)
    }

    override fun onBindViewHolder(holder: CitiesHolder, position: Int) {
        with(holder){
            with(list[position]){
                viewModel.onBindCity(binding, this.cityName, R.id.action_citiesFragment_to_placesFragment)
            }
        }
    }

    override fun getItemCount(): Int = list.size
}