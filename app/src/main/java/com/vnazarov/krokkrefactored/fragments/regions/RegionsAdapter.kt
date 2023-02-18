package com.vnazarov.krokkrefactored.fragments.regions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vnazarov.krokkrefactored.databinding.RegionItemBinding

class RegionsAdapter(private val list: List<Any>): RecyclerView.Adapter<RegionsAdapter.RegionsHolder>() {

    inner class RegionsHolder(val binding: RegionItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionsHolder {
        val binding = RegionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RegionsHolder(binding)
    }

    override fun onBindViewHolder(holder: RegionsHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = list.size
}