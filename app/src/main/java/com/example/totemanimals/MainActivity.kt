package com.example.totemanimals

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.GridLayout
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mAdView: AdView
    private val adapter1 = AnimalsAdaptList()
    private val imIdList = listOf(R.drawable.smallbelka,R.drawable.smallbober,R.drawable.smallezh,
        R.drawable.smallfilin,R.drawable.smallkon,R.drawable.smalllebed,R.drawable.smalllisa,
        R.drawable.smallmedved,R.drawable.smallolen,R.drawable.smallorel,R.drawable.smallpetuh,
        R.drawable.smallslon,R.drawable.smalltur,R.drawable.smalluzh,R.drawable.smallvolk,)
private var indexImList = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        buttonEffectonClick(menu_bt_my_test)
        buttonEffectonClick(menu_bt_info)
        buttonEffectonClick(menu_bt_searchlist)
        buttonEffectonClick(menu_bt_exit)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) // Отключение ночной темы для этого активити

        MobileAds.initialize(this) {}
        mAdView=findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


    }


    fun onClickOpenMenu(view: View) {
        buttonEffectonClick(btn_open_menu)
        val menuOpenClose = Animations()
        menuOpenClose.anim_menu_up_down(frame_menu,btn_open_menu)
        if (frame_menu.visibility==View.VISIBLE) {btn_open_menu.setImageResource(R.drawable.ic_expand_more_black_32dp)}
        else {btn_open_menu.setImageResource(R.drawable.ic_expand_less_black_32dp)}
    }

    fun buttonEffectonClick(imageButton: View) {
        imageButton.setOnTouchListener{
            v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {v.background.setColorFilter(-0x1f0b8adf, PorterDuff.Mode.SRC_ATOP)
                v.invalidate()
                }
                MotionEvent.ACTION_UP -> {
                    v.background.clearColorFilter()
                    v.invalidate()
                }
            }
            false
        }
    }

    fun onClickExitButton (view: View) {
        buttonEffectonClick(menu_bt_exit)
        finishAndRemoveTask()
                    }

    fun onClickInfo(view: View){
        buttonEffectonClick(menu_bt_info)
    }

    fun onClickSearchList(view: View){
        buttonEffectonClick(menu_bt_searchlist)

    }

    fun onClickMyTest(view: View){
        buttonEffectonClick(menu_bt_my_test)
    }




private fun init() {
    rcView_AnList.layoutManager = GridLayoutManager(this@MainActivity,3)
    rcView_AnList.adapter = adapter1
    menu_bt_searchlist.setOnClickListener {
        if(indexImList > imIdList.size-1) indexImList = 0
        val animal = Animal(imIdList[indexImList],"Животное $indexImList")
        adapter1.addAnimal(animal)
        indexImList++
    }
}
}

