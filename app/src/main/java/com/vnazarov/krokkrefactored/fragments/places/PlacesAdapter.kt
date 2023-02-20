package com.vnazarov.krokkrefactored.fragments.places

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vnazarov.krokkrefactored.R
import com.vnazarov.krokkrefactored.databinding.PlaceItemBinding
import com.vnazarov.krokkrefactored.objects.Place
import com.vnazarov.krokkrefactored.utilits.vm.PlacesViewModel

class PlacesAdapter(private val list: List<Place>, private val viewModel: PlacesViewModel): RecyclerView.Adapter<PlacesAdapter.PlacesHolder>() {

    inner class PlacesHolder(val binding: PlaceItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesHolder {
        val binding = PlaceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PlacesHolder(binding)
    }

    override fun onBindViewHolder(holder: PlacesHolder, position: Int) {
        with(holder){
            with(list[position]){
                viewModel.onBindPlaces(binding, this.name, R.id.action_placesFragment_to_currentPlaceFragment)
            }
        }
    }

    override fun getItemCount(): Int = list.size
}