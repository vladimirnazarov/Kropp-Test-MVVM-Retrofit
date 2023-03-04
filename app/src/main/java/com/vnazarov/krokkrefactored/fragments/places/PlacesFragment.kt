package com.vnazarov.krokkrefactored.fragments.places

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
import com.vnazarov.krokkrefactored.databinding.FragmentPlacesBinding
import com.vnazarov.krokkrefactored.objects.City
import com.vnazarov.krokkrefactored.objects.Place
import com.vnazarov.krokkrefactored.utilits.adapters.PlacesAdapter
import com.vnazarov.krokkrefactored.utilits.vm.MainActivityViewModel
import com.vnazarov.krokkrefactored.utilits.vm.PlacesViewModel

class PlacesFragment: Fragment() {

    private lateinit var mBinding: FragmentPlacesBinding
    private lateinit var mToolbar: Toolbar
    private lateinit var adapter: PlacesAdapter
    private lateinit var mRecyclerView: RecyclerView
    private val viewModel: PlacesViewModel by activityViewModels()
    private val activityViewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentPlacesBinding.inflate(layoutInflater)
        mToolbar = mBinding.placesToolbar

        viewModel.setCity(arguments?.getInt("pass_data_city"))
        viewModel.setLanguage(arguments?.getInt("pass_data_lang"))
        viewModel.setCities(activityViewModel.getCities() as ArrayList<City>)

        viewModel.initializeToolbar(activity as MainActivity, mToolbar, viewModel.getCity())

        mRecyclerView = mBinding.placesRv
        mRecyclerView.layoutManager = LinearLayoutManager(activity)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.defineNavController(view)

        viewModel.setPlaces(activityViewModel.getPlaces() as ArrayList<Place>)

        adapter = PlacesAdapter(viewModel.initializePlaces(), viewModel, R.id.action_placesFragment_to_currentPlaceFragment)
        mRecyclerView.adapter = adapter
    }
}