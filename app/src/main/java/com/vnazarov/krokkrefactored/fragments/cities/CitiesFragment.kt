package com.vnazarov.krokkrefactored.fragments.cities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.vnazarov.krokkrefactored.MainActivity
import com.vnazarov.krokkrefactored.R
import com.vnazarov.krokkrefactored.databinding.FragmentCitiesBinding
import com.vnazarov.krokkrefactored.utilits.vm.CitiesViewModel

class CitiesFragment: Fragment() {

    private lateinit var mBinding: FragmentCitiesBinding
    private lateinit var mToolbar: Toolbar
    private val viewModel: CitiesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentCitiesBinding.inflate(layoutInflater)
        mToolbar = mBinding.citiesToolbar
        viewModel.initializeToolbar(activity as MainActivity, mToolbar, "Cities")

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.defineNavController(view)

        mBinding.textView2.setOnClickListener {
            viewModel.navigateTo(R.id.action_citiesFragment_to_placesFragment, fromName = "cities")
        }
    }
}