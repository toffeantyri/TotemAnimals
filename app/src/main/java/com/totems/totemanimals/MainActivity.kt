package com.totems.totemanimals

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.totems.totemanimals.resoursesTests.list_resours
import com.totems.totemanimals.view.mainFragments.fragment_testResult
import com.totems.totemanimals.view.mainAdapters.Animal
import com.totems.totemanimals.view.mainAdapters.AnimalsAdaptList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity_ApComAct() {
    lateinit var mAdView: AdView
    private val adapter1 = AnimalsAdaptList()
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        initRV()
        addAllAnimalOnRV()
        rcView_AnList.visibility = View.GONE
        my_info_frame.visibility = View.GONE

        supportFragmentManager.beginTransaction()
            .replace(R.id.my_testResult_frame,
                fragment_testResult.newInstance(
                    setUpPreference()
                )
            ).commit()
        my_testResult_frame.visibility = View.VISIBLE

        initAd()
        setUpBottomNavigationMenu()

        handler = Handler()
        Log.d("MyLog", "OnCreate MainActivity")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("MyLog", "OnActivityResult MainActivity")
        if (requestCode==100 && resultCode==Activity.RESULT_OK && data!=null) {
            val f_n = data.getIntExtra("first_name",-1 )
            val f_v = data.getIntExtra("first_volume",-1)
            val s_n = data.getIntExtra("second_name",-1)
            val s_v = data.getIntExtra("second_volume",-1)
            val l_n = data.getIntExtra("last_name",-1)
            val a_v = data.getIntExtra("all_volume",-1)
        val result_array = arrayOf(1,f_n,f_v,s_n,s_v,l_n,a_v)
            Log.d("MyLog","onActivityResult $f_n $f_v $s_n $s_v $l_n $a_v " )
            supportFragmentManager.beginTransaction()
                .replace(R.id.my_testResult_frame,
                    fragment_testResult.newInstance(
                        result_array
                    )
                ).commit()
        }
        else { Log.d("MyLog", " OnActivityResult : НЕ requestCode==100 && resultCode==Activity.RESULT_OK && data!=null ")        }
    }

    fun addAllAnimalOnRV() {
        if (list_resours.imIdList.count() != rcView_AnList.layoutManager?.itemCount) {
            var a: Int
            var b: String
            var c: String
            var animalAdd: Animal
            var index = 0
            for (i in list_resours.imIdList) {
                a = list_resours.imIdList[index]
                b = list_resours.nameIdList[index]
                c = list_resours.descriptIdList[index]
                animalAdd = Animal(a, b, c)
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

    //TODO изменить в activity_main.xml
    fun initAd() {
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }


    var double_back_press = false
    override fun onBackPressed() {

        if(double_back_press==true) {
            super.onBackPressed()        }
        double_back_press=true
        handler.postDelayed({double_back_press=false},2000)

        val aDialog = AlertDialog.Builder(this)
        aDialog.apply {
            setMessage(R.string.Alert_message_exit)
                .setCancelable(true)
                .setPositiveButton(
                    R.string.Alert_yes,
                    DialogInterface.OnClickListener { dialog, id -> super.onBackPressed() })
        }
            aDialog.setNegativeButton(R.string.Alert_no,DialogInterface.OnClickListener{dialog, id -> dialog.cancel()  })

        val alert = aDialog.create()
        alert.show()





    }




}


