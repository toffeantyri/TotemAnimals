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
    val imIdList = listOf(R.drawable.smallbelka,R.drawable.smallbober,R.drawable.smallezh,
        R.drawable.smallfilin,R.drawable.smallkon,R.drawable.smalllebed,R.drawable.smalllisa,
        R.drawable.smallmedved,R.drawable.smallolen,R.drawable.smallorel,R.drawable.smallpetuh,
        R.drawable.smallslon,R.drawable.smalltur,R.drawable.smalluzh,R.drawable.smallvolk,)
    val nameIdList = listOf("Белка","Бобёр","Ёж","Филин","Конь","Лебедь","Лисица","Медведь","Олень","Орёл","Петух","Слон","Тур","Уж","Волк",)
    val descriptIdList = listOf("one", "two", "three","four", "five","six","seven", "eigth", "nine","ten","eleven","twelf", "1three", "1four","1five",)



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
                R.id.home_menu_id -> {
                    rcView_AnList.visibility=View.INVISIBLE
                }
                R.id.search_menu_id -> {
                    rcView_AnList.visibility=View.VISIBLE
                    addAllAnimalOnRV ()
                }
                R.id.info_menu_id -> {
                    rcView_AnList.visibility=View.INVISIBLE
                    Log.d("MyLog","count:${imIdList.count()} Количество итемов: ${rcView_AnList.layoutManager?.itemCount}   ")
                }
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


    fun addAllAnimalOnRV () {
        if(imIdList.count()!=rcView_AnList.layoutManager?.itemCount){
            var index = 0
            var a : Int
            var b: String
            var c: String
            var animalAdd : Animal
            for (i in imIdList) {
                a = imIdList[index]
                b = nameIdList[index]
                c = descriptIdList[index]
                animalAdd = Animal(a, b, c)
                adapter1.addAnimal(animalAdd)
                index++
            }
        }
        }


    private fun init() {
        rcView_AnList.layoutManager = GridLayoutManager(this@MainActivity, 3)
        rcView_AnList.adapter = adapter1
    }
}

