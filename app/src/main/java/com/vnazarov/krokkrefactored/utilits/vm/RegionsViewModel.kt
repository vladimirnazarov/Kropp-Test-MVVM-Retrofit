package com.vnazarov.krokkrefactored.utilits.vm

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.vnazarov.krokkrefactored.MainActivity
import com.vnazarov.krokkrefactored.R
import com.vnazarov.krokkrefactored.objects.Region
import com.vnazarov.krokkrefactored.utilits.BaseViewModel
import com.vnazarov.krokkrefactored.utilits.adapters.RegionsAdapter

class RegionsViewModel : BaseViewModel() {

    var toolbarTitle = "Regions"
    private lateinit var adapter: RegionsAdapter
    private var regionsData = arrayListOf<Region>()

    private fun initializeRegions() {
        val region11 = Region("Брэсцкая вобласць", R.drawable.r_emblem_brest, 1, "Brest region")
        val region21 = Region("Brest region", R.drawable.r_emblem_brest, 2, "Brest region")
        val region31 = Region("Брестская область", R.drawable.r_emblem_brest, 3, "Brest region")
        val region41 = Region("Brestská oblast", R.drawable.r_emblem_brest, 4, "Brest region")
        val region51 = Region("布雷斯特地区", R.drawable.r_emblem_brest, 5, "Brest region")

        val region12 = Region("Віцебская вобласць", R.drawable.r_emblem_vitebsk, 1, "Vitebsk region")
        val region22 = Region("Vitebsk region", R.drawable.r_emblem_vitebsk, 2, "Vitebsk region")
        val region32 = Region("Витебская область", R.drawable.r_emblem_vitebsk, 3, "Vitebsk region")
        val region42 = Region("Vitebská oblast", R.drawable.r_emblem_vitebsk, 4, "Vitebsk region")
        val region52 = Region("维捷布斯克地区", R.drawable.r_emblem_vitebsk, 5, "Vitebsk region")

        val region13 = Region("Гомельская вобласть", R.drawable.r_emblem_homel, 1, "Gomel region")
        val region23 = Region("Gomel region", R.drawable.r_emblem_homel, 2, "Gomel region")
        val region33 = Region("Гомельская область", R.drawable.r_emblem_homel, 3, "Gomel region")
        val region43 = Region("Gomelská oblast", R.drawable.r_emblem_homel, 4, "Gomel region")
        val region53 = Region("戈梅利地区", R.drawable.r_emblem_homel, 5, "Gomel region")

        val region14 = Region("Гродзенская вобласць", R.drawable.r_emblem_hrodna, 1, "Grodno region")
        val region24 = Region("Grodno region", R.drawable.r_emblem_hrodna, 2, "Grodno region")
        val region34 = Region("Гродненская область", R.drawable.r_emblem_hrodna, 3, "Grodno region")
        val region44 = Region("Region Grodno", R.drawable.r_emblem_hrodna, 4, "Grodno region")
        val region54 = Region("格罗德诺地区", R.drawable.r_emblem_hrodna, 5, "Grodno region")

        val region15 = Region("Магілёўская вобласць", R.drawable.r_emblem_mahileu, 1, "Mogilev region")
        val region25 = Region("Mogilev region", R.drawable.r_emblem_mahileu, 2, "Mogilev region")
        val region35 = Region("Могилёвская область", R.drawable.r_emblem_mahileu, 3, "Mogilev region")
        val region45 = Region("Mogilevská oblast", R.drawable.r_emblem_mahileu, 4, "Mogilev region")
        val region55 = Region("莫吉廖夫地区", R.drawable.r_emblem_mahileu, 5, "Mogilev region")

        val region16 = Region("Мінская вобласць", R.drawable.r_emblem_minsk, 1, "Minsk region")
        val region26 = Region("Minsk region", R.drawable.r_emblem_minsk, 2, "Minsk region")
        val region36 = Region("Минская область", R.drawable.r_emblem_minsk, 3, "Minsk region")
        val region46 = Region("Minská oblast", R.drawable.r_emblem_minsk, 4, "Minsk region")
        val region56 = Region("明斯克地区", R.drawable.r_emblem_minsk, 5, "Minsk region")

        regionsData = arrayListOf(
            region11, region12, region13, region14, region15, region16,
            region21, region22, region23, region24, region25, region26,
            region31, region32, region33, region34, region35, region36,
            region41, region42, region43, region44, region45, region46,
            region51, region52, region53, region54, region55, region56
        )
    }

    private fun initializeDialog(activity: MainActivity, adapter: RegionsAdapter, rv: RecyclerView, mToolbar: Toolbar, activityViewModel: MainActivityViewModel, context: Context){
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_language_chose)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)

        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(dialog.window!!.attributes)
        layoutParams.width = 1000
        dialog.window?.attributes = layoutParams

        initializeDialogButtons(dialog, adapter, rv, mToolbar, activityViewModel, context)

        dialog.show()
    }

    private fun initializeDialogButtons(dialog: Dialog, adapter: RegionsAdapter, rv: RecyclerView, mToolbar: Toolbar, activityViewModel: MainActivityViewModel, context: Context){
        val rLang1 = dialog.findViewById<ConstraintLayout>(R.id.lang_1_dialog)
        val rLang2 = dialog.findViewById<ConstraintLayout>(R.id.lang_2_dialog)
        val rLang3 = dialog.findViewById<ConstraintLayout>(R.id.lang_3_dialog)
        val rLang4 = dialog.findViewById<ConstraintLayout>(R.id.lang_4_dialog)
        val rLang5 = dialog.findViewById<ConstraintLayout>(R.id.lang_5_dialog)

        rLang1.setOnClickListener {
            Toast.makeText(context, "Калі ласка, пачакайце пакуль усе дадзеныя не загрузяцца", Toast.LENGTH_LONG).show()
            activityViewModel.loadData(context, {
                dialog.hide()

                toolbarTitle = "Вобласці"
                mToolbar.title = toolbarTitle
                initLangData(1, adapter, rv)
            }, {
                dialog.setContentView(R.layout.dialog_language_chose)
            }, {
                dialog.setContentView(R.layout.dialog_await)
            })
        }
        rLang2.setOnClickListener {
            Toast.makeText(context, "Please, wait until all data is loaded", Toast.LENGTH_LONG).show()
            activityViewModel.loadData(context, {
                dialog.hide()

                toolbarTitle = "Regions"
                mToolbar.title = toolbarTitle
                initLangData(2, adapter, rv)
            }, {
                dialog.setContentView(R.layout.dialog_language_chose)
            }, {
                dialog.setContentView(R.layout.dialog_await)
            })
        }
        rLang3.setOnClickListener {
            Toast.makeText(context, "Пожалуйста, подождите пока все данные не загрузятся", Toast.LENGTH_LONG).show()
            activityViewModel.loadData(context, {
                dialog.hide()

                toolbarTitle = "Области"
                mToolbar.title = toolbarTitle
                initLangData(3, adapter, rv)
            }, {
                dialog.setContentView(R.layout.dialog_language_chose)
            }, {
                dialog.setContentView(R.layout.dialog_await)
            })
        }
        rLang4.setOnClickListener {
            Toast.makeText(context, "Počkejte prosím, dokud nebudou nahrána všechna data", Toast.LENGTH_LONG).show()
            activityViewModel.loadData(context, {
                dialog.hide()

                toolbarTitle = "Oblasti"
                mToolbar.title = toolbarTitle
                initLangData(4, adapter, rv)
            }, {
                dialog.setContentView(R.layout.dialog_language_chose)
            }, {
                dialog.setContentView(R.layout.dialog_await)
            })
        }
        rLang5.setOnClickListener {
            Toast.makeText(context, "请等待，直到所有的数据都已上传", Toast.LENGTH_LONG).show()
            activityViewModel.loadData(context, {
                dialog.hide()

                toolbarTitle = "地区"
                mToolbar.title = toolbarTitle
                initLangData(5, adapter, rv)
            }, {
                dialog.setContentView(R.layout.dialog_language_chose)
            }, {
                dialog.setContentView(R.layout.dialog_await)
            })
        }
    }

    private fun initLangData(language: Int, adapter: RegionsAdapter, rv: RecyclerView){
        val indexArray = arrayListOf<Region>()
        for (i in regionsData){
            if (i.language != language){
                indexArray.add(i)
            }
        }

        regionsData.removeAll(indexArray.toSet())
        rv.adapter = adapter
    }

    fun initAdapter(activity: MainActivity, rv: RecyclerView, mToolbar: Toolbar, activityViewModel: MainActivityViewModel, context: Context){
        if (regionsData.size == 0){
            initializeRegions()
            adapter = RegionsAdapter(regionsData, this, R.id.action_regionsFragment_to_citiesFragment)
            initializeDialog(activity, adapter, rv, mToolbar, activityViewModel, context)
        } else {
            adapter = RegionsAdapter(regionsData, this, R.id.action_regionsFragment_to_citiesFragment)
            rv.adapter = adapter
        }
    }
}