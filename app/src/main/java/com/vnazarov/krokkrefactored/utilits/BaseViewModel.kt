package com.vnazarov.krokkrefactored.utilits

import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import com.vnazarov.krokkrefactored.MainActivity
import com.vnazarov.krokkrefactored.databinding.RvItemBinding

open class BaseViewModel: ViewModel() {

    private lateinit var navController: NavController

    fun defineNavController(view: View){
        navController = view.findNavController()
    }

    private fun navigateTo(address: Int, region: String = "", city: Int = 0, language: Int = 0, fromName: String){
        navController.navigate(
            address,
            bundleOf(
                "${fromName}_str" to region,
                "${fromName}_lang" to language,
                "${fromName}_city" to city
                ),
            navOptions {
                anim {
                    enter = androidx.navigation.ui.R.anim.nav_default_enter_anim
                    popEnter = androidx.navigation.ui.R.anim.nav_default_pop_enter_anim
                    popExit = androidx.navigation.ui.R.anim.nav_default_pop_exit_anim
                    exit = androidx.navigation.ui.R.anim.nav_default_exit_anim
                }
            })
    }

    fun initializeToolbar(activity: MainActivity, toolbar: Toolbar, title: String, popBack: Boolean = true){
        if (popBack){
            toolbar.title = title
            activity.setSupportActionBar(toolbar)
            activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            toolbar.setNavigationOnClickListener {
                activity.onBackPressed()
            }
        } else {
            toolbar.title = title
            activity.setSupportActionBar(toolbar)
        }
    }

    fun onBindItem(binding: RvItemBinding, name: String, address: Int, isRegion: Boolean = false, isCity: Boolean = false, region: String = "", city: Int = 0, language: Int = 0){
        binding.itemName.text = name

        binding.fullItem.isClickable = true
        binding.fullItem.setOnClickListener {
            if (isRegion) navigateTo(address = address, region = region, language = language, fromName = "pass_data")
            else if (isCity) navigateTo(address = address, city = city, language = language, fromName = "pass_data")
            else navigateTo(address, fromName = name)
        }
    }
}