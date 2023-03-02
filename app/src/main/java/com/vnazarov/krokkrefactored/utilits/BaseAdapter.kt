package com.vnazarov.krokkrefactored.utilits

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.vnazarov.krokkrefactored.databinding.RvItemBinding
import com.vnazarov.krokkrefactored.objects.City
import com.vnazarov.krokkrefactored.objects.Place
import com.vnazarov.krokkrefactored.objects.Region

open class BaseAdapter(
    private val list: List<Any>,
    private val viewModel: BaseViewModel,
    private val address: Int,
) : RecyclerView.Adapter<BaseAdapter.BaseHolder>() {

    inner class BaseHolder(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return BaseHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                when (this) {
                    is Region -> {
                        viewModel.onBindItem(binding, this.name, address, true, region = this.region, language = this.language)
                        binding.image.load(this.imageId)
                    }
                    is City -> {
                        viewModel.onBindItem(binding, this.cityName, address, isCity = true, city = this.id, language = this.language)
                        binding.image.load(this.cityEmblem)
                    }
                    is Place -> {
                        viewModel.onBindItem(binding, this.name, address, isPlace = true, place = this)
                        binding.image.load(this.logo)
                    } else -> Log.e("Adapter error", "Something went wrong")
                }
            }
        }
    }

    override fun getItemCount(): Int = list.size
}