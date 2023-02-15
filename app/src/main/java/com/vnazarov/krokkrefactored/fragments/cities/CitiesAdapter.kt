package com.vnazarov.krokkrefactored.fragments.cities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vnazarov.krokkrefactored.databinding.CityItemBinding

class CitiesAdapter(val list: List<Any>): RecyclerView.Adapter<CitiesAdapter.CitiesHolder>() {

    inner class CitiesHolder(val binding: CityItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesHolder {
        val binding = CityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CitiesHolder(binding)
    }

    override fun onBindViewHolder(holder: CitiesHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = list.size
}