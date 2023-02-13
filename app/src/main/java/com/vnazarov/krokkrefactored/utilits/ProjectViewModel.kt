package com.vnazarov.krokkrefactored.utilits

import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.navOptions

open class ProjectViewModel: ViewModel() {

    private lateinit var navController: NavController

    fun defineNavController(view: View){
        navController = view.findNavController()
    }

    fun navigateTo(address: Int, array: ArrayList<Any> = arrayListOf(), fromName: String){
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
}