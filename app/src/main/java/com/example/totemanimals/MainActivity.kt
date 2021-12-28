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
import kotlin.contracts.ContractBuilder

class MainActivity : AppCompatActivity() {
    lateinit var mAdView: AdView
    private val adapter1 = AnimalsAdaptList()
//    val imIdList = listOf(R.drawable.smallbelka,R.drawable.smallbober,R.drawable.smallezh,
//        R.drawable.smallfilin,R.drawable.smallkon,R.drawable.smalllebed,R.drawable.smalllisa,
//        R.drawable.smallmedved,R.drawable.smallolen,R.drawable.smallorel,R.drawable.smallpetuh,
//        R.drawable.smallslon,R.drawable.smalltur,R.drawable.smalluzh,R.drawable.smallvolk,)
//    val big_imIdList = listOf(R.drawable.smallbelka,R.drawable.smallbober,R.drawable.smallezh,
//        R.drawable.smallfilin,R.drawable.smallkon,R.drawable.smalllebed,R.drawable.smalllisa,
//        R.drawable.smallmedved,R.drawable.smallolen,R.drawable.smallorel,R.drawable.smallpetuh,
//        R.drawable.smallslon,R.drawable.smalltur,R.drawable.smalluzh,R.drawable.smallvolk,)
//
//    val nameIdList = listOf("Белка","Бобёр","Ёж","Филин","Конь","Лебедь","Лисица","Медведь","Олень","Орёл","Петух","Слон","Тур","Уж","Волк",)
//    val descriptIdList = listOf("one", "two", "three","four", "five","six","seven", "eigth", "nine","ten","eleven","twelf", "1three", "1four","1five",)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        addAllAnimalOnRV()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) // Отключение ночной темы для этого активити

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        nav_bottom_menu.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home_menu_id -> {
                    rcView_AnList.visibility=View.GONE
                }
                R.id.search_menu_id -> {
                    rcView_AnList.visibility=View.VISIBLE
                                    }
                R.id.info_menu_id -> {
                    rcView_AnList.visibility=View.GONE
                    Log.d("MyLog","count:${list_resours.imIdList.count()} Количество итемов: ${rcView_AnList.layoutManager?.itemCount}   ")
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
        if(list_resours.imIdList.count()!=rcView_AnList.layoutManager?.itemCount){
            var index = 0
            var a : Int
            var a1: Int
            var b: String
            var c: String
            var animalAdd : Animal
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


    private fun init() {
        rcView_AnList.layoutManager = GridLayoutManager(this@MainActivity, 3)
        rcView_AnList.adapter = adapter1
        adapter1.onItemClick = {Animal ->
            val intent = Intent(this, Animal_descpt_view::class.java)
            intent.putExtra("description_search",Animal)
            startActivity(intent)

            }
    }
}

