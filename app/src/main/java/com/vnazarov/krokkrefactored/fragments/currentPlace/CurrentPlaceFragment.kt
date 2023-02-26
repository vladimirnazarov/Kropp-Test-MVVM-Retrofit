package com.vnazarov.krokkrefactored.fragments.currentPlace

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.vnazarov.krokkrefactored.MainActivity
import com.vnazarov.krokkrefactored.databinding.FragmentCurrentPlaceBinding
import com.vnazarov.krokkrefactored.utilits.vm.CurrentPlaceViewModel

class CurrentPlaceFragment: Fragment() {

    private lateinit var mBinding: FragmentCurrentPlaceBinding
    private lateinit var mToolbar: Toolbar
    private val viewModel: CurrentPlaceViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentCurrentPlaceBinding.inflate(layoutInflater)
        mToolbar = mBinding.currentPlaceToolbar
        viewModel.initializeToolbar(activity as MainActivity, mToolbar, "Current place")

        return mBinding.root
    }

    override fun onResume() {
        super.onResume()

        viewModel.initializeMediaPlayer("https://krokapp.by/media/sound/94a41eaf-ef06-42e5-8681-08f40185dac4.ogg", mBinding)

        mBinding.apPlayButton.setOnClickListener {
            viewModel.playAudio(mBinding)
        }
    }

    override fun onStop() {
        super.onStop()

        viewModel.mpStop()
    }
}