package com.example.totemanimals

import android.app.Activity
import android.app.Dialog
import android.app.Instrumentation
import android.content.DialogInterface
import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_fragment_test_result.*
import kotlin.contracts.ContractBuilder

class MainActivity : BaseActivity_ApComAct() {
    lateinit var mAdView: AdView
    private val adapter1 = AnimalsAdaptList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var pref0 = setUpPreference()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        initRV()
        addAllAnimalOnRV()
        rcView_AnList.visibility = View.GONE
        my_info_frame.visibility = View.GONE
        supportFragmentManager.beginTransaction()
            .replace(R.id.my_testResult_frame, fragment_testResult.newInstance(setUpPreference())).commit()
        my_testResult_frame.visibility = View.VISIBLE
        initAd()
        setUpBottomNavigationMenu()
    }

    fun addAllAnimalOnRV() {
        if (list_resours.imIdList.count() != rcView_AnList.layoutManager?.itemCount) {
            var index = 0
            var a: Int
            var a1: Int
            var b: String
            var c: String
            var animalAdd: Animal
            for (i in list_resours.imIdList) {
                a = list_resours.imIdList[index]
                a1 = list_resours.big_imIdList[index]
                b = list_resours.nameIdList[index]
                c = list_resours.descriptIdList[index]
                animalAdd = Animal(a, a1, b, c)
                adapter1.addAnimal(animalAdd)
                index++
            }
        }
    }

    private fun initRV() {
        rcView_AnList.layoutManager = GridLayoutManager(this@MainActivity, 3)
        rcView_AnList.adapter = adapter1
        adapter1.onItemClick = { Animal ->
            val intent = Intent(this, Animal_descpt_view::class.java)
            intent.putExtra("description_search", Animal)
            startActivity(intent)

        }
    }

    fun initAd() {
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }
}


