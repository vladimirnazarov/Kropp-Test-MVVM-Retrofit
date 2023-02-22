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

    private fun navigateTo(address: Int, array: ArrayList<Any> = arrayListOf(), fromName: String){
        navController.navigate(
            address,
            bundleOf(fromName to array),
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

    fun onBindItem(binding: RvItemBinding, name: String, address: Int){
        binding.itemName.text = name

        binding.fullItem.isClickable = true
        binding.fullItem.setOnClickListener {
            navigateTo(address, fromName = name)
        }
    }
}