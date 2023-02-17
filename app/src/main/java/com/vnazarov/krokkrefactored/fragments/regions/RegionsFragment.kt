package com.vnazarov.krokkrefactored.fragments.regions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.vnazarov.krokkrefactored.MainActivity
import com.vnazarov.krokkrefactored.R
import com.vnazarov.krokkrefactored.databinding.FragmentRegionsBinding
import com.vnazarov.krokkrefactored.utilits.vm.RegionsViewModel

class RegionsFragment : Fragment() {

    private lateinit var mBinding: FragmentRegionsBinding
    private lateinit var mToolbar: Toolbar
    private val viewModel: RegionsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentRegionsBinding.inflate(layoutInflater)
        mToolbar = mBinding.regionsToolbar
        viewModel.initializeToolbar(activity as MainActivity, mToolbar, "Regions", false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.defineNavController(view)

        mBinding.textView4.setOnClickListener {
            viewModel.navigateTo(R.id.action_regionsFragment_to_citiesFragment, fromName = "regions")
        }
    }
}