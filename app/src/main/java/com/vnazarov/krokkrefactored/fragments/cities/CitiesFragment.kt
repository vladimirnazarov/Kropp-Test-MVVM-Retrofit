package com.vnazarov.krokkrefactored.fragments.cities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vnazarov.krokkrefactored.MainActivity
import com.vnazarov.krokkrefactored.R
import com.vnazarov.krokkrefactored.databinding.FragmentCitiesBinding
import com.vnazarov.krokkrefactored.objects.City
import com.vnazarov.krokkrefactored.utilits.adapters.CitiesAdapter
import com.vnazarov.krokkrefactored.utilits.vm.CitiesViewModel
import com.vnazarov.krokkrefactored.utilits.vm.MainActivityViewModel

class CitiesFragment: Fragment() {

    private lateinit var mBinding: FragmentCitiesBinding
    private lateinit var mToolbar: Toolbar
    private lateinit var adapter: CitiesAdapter
    private lateinit var mRecyclerView: RecyclerView
    private val activityViewModel: MainActivityViewModel by activityViewModels()
    private val viewModel: CitiesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentCitiesBinding.inflate(layoutInflater)
        mToolbar = mBinding.citiesToolbar

        viewModel.setRegion(arguments?.getString("pass_data_str"))
        viewModel.setLanguage(arguments?.getInt("pass_data_lang"))

        viewModel.initializeToolbar(activity as MainActivity, mToolbar, viewModel.getRegion())

        mRecyclerView = mBinding.citiesRv
        mRecyclerView.layoutManager = LinearLayoutManager(activity)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.defineNavController(view)

        viewModel.setCities(activityViewModel.getCities() as ArrayList<City>)

        adapter = CitiesAdapter(viewModel.initializeCities(), viewModel, R.id.action_citiesFragment_to_placesFragment)
        mRecyclerView.adapter = adapter
    }
}