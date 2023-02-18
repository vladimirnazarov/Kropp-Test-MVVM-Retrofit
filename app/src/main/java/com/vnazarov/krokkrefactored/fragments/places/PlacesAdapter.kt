package com.vnazarov.krokkrefactored.fragments.places

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vnazarov.krokkrefactored.databinding.PlaceItemBinding

class PlacesAdapter(val list: List<Any>): RecyclerView.Adapter<PlacesAdapter.PlacesHolder>() {

    inner class PlacesHolder(val binding: PlaceItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesHolder {
        val binding = PlaceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PlacesHolder(binding)
    }

    override fun onBindViewHolder(holder: PlacesHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = list.size
}