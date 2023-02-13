package com.vnazarov.krokkrefactored.fragments.places

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.vnazarov.krokkrefactored.R
import com.vnazarov.krokkrefactored.databinding.FragmentPlacesBinding
import com.vnazarov.krokkrefactored.utilits.vm.PlacesViewModel

class PlacesFragment: Fragment() {

    private lateinit var mBinding: FragmentPlacesBinding
    private val viewModel: PlacesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentPlacesBinding.inflate(layoutInflater)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.defineNavController(view)

        mBinding.textView3.setOnClickListener {
            viewModel.navigateTo(R.id.action_placesFragment_to_currentPlaceFragment, fromName = "places")
        }
    }
}