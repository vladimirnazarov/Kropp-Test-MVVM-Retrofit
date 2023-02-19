package com.vnazarov.krokkrefactored.fragments.regions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vnazarov.krokkrefactored.R
import com.vnazarov.krokkrefactored.databinding.RegionItemBinding
import com.vnazarov.krokkrefactored.objects.Region
import com.vnazarov.krokkrefactored.utilits.vm.RegionsViewModel

class RegionsAdapter(private val list: List<Region>, private val viewModel: RegionsViewModel): RecyclerView.Adapter<RegionsAdapter.RegionsHolder>() {

    inner class RegionsHolder(val binding: RegionItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionsHolder {
        val binding = RegionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RegionsHolder(binding)
    }

    override fun onBindViewHolder(holder: RegionsHolder, position: Int) {
        with(holder){
            with(list[position]){
                viewModel.onBindRegion(binding, this.name, R.id.action_regionsFragment_to_citiesFragment)
            }
        }
    }

    override fun getItemCount(): Int = list.size
}