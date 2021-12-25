package com.example.totemanimals

import android.app.Activity
import android.app.Dialog
import android.app.Instrumentation
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
import kotlin.contracts.ContractBuilder

class MainActivity : AppCompatActivity() {
    lateinit var mAdView: AdView
    private val adapter1 = AnimalsAdaptList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()


        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) // Отключение ночной темы для этого активити

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        init()

        nav_bottom_menu.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home_menu_id -> {}
                R.id.search_menu_id -> {
                    val intent = Intent(this, animal_editor_activity::class.java)
                    intent.putExtra("add","add")
                    startActivityForResult(intent, 100)
                }
                R.id.info_menu_id -> {}
                R.id.exit_menu_id -> { finish() }
            }

            true
        }
    }


    fun onClickExitButton(view: View) {

        finish()
    }

    fun onClickInfo(view: View) {

    }

    fun onClickSearchList(view: View) {


    }

    fun onClickMyTest(view: View) {

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            adapter1.addAnimal(data?.getSerializableExtra("animal") as Animal)
        }
    }

    private fun init() {
        rcView_AnList.layoutManager = GridLayoutManager(this@MainActivity, 3)
        rcView_AnList.adapter = adapter1
    }
}

