package com.vnazarov.krokkrefactored.fragments.currentPlace

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.vnazarov.krokkrefactored.MainActivity
import com.vnazarov.krokkrefactored.databinding.FragmentCurrentPlaceBinding
import com.vnazarov.krokkrefactored.utilits.vm.CurrentPlaceViewModel

class CurrentPlaceFragment: Fragment() {

    private lateinit var mBinding: FragmentCurrentPlaceBinding
    private lateinit var mToolbar: Toolbar
    private val viewModel: CurrentPlaceViewModel by activityViewModels()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentCurrentPlaceBinding.inflate(layoutInflater)
        mToolbar = mBinding.currentPlaceToolbar
        viewModel.initializeToolbar(activity as MainActivity, mToolbar, "Current place")

        viewModel.setPlace(arguments?.getStringArrayList("pass_data_place"))
        val placeData = viewModel.getPlace()

        if (placeData[2] == "") mBinding.currentPlaceAudioPlayer.visibility = View.GONE
        mBinding.currentPlaceImage.load(placeData[3])
        mBinding.currentPlaceTitle.text = placeData[0]
        mBinding.currentPlaceText.text = Html.fromHtml(placeData[1], Html.FROM_HTML_MODE_LEGACY)

        return mBinding.root
    }

    override fun onResume() {
        super.onResume()

        if (viewModel.getPlace()[2] != "") {
            viewModel.initializeMediaPlayer(viewModel.getPlace()[2], mBinding)
            mBinding.apPlayButton.setOnClickListener {
                viewModel.playAudio(mBinding)
            }
        }
    }

    override fun onStop() {
        super.onStop()

        if (viewModel.getPlace()[2] != "") {
            viewModel.mpStop()
        }
    }
}