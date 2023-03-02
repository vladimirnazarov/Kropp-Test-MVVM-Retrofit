package com.vnazarov.krokkrefactored

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.vnazarov.krokkrefactored.databinding.ActivityMainBinding
import com.vnazarov.krokkrefactored.utilits.retrofit.common.Common
import com.vnazarov.krokkrefactored.utilits.retrofit.`interface`.RetrofitServices
import com.vnazarov.krokkrefactored.utilits.vm.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mService: RetrofitServices

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mService = Common.retrofitService
        viewModel.setService(mService)
    }
}