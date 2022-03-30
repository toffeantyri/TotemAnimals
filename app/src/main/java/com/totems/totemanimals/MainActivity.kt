package com.totems.totemanimals

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.totems.totemanimals.resoursesTests.List_resours_an_totem
import com.totems.totemanimals.view.mainAdapters.totemanimaladapters.ShablonAnimalDataClass
import com.totems.totemanimals.view.mainAdapters.totemanimaladapters.AnimalsAdaptList
import com.totems.totemanimals.view.mainActivityFragments.fragment_testResult
import com.totems.totemanimals.viewModel.DataModelTestResult
import com.yandex.mobile.ads.banner.AdSize
import com.yandex.mobile.ads.banner.BannerAdEventListener
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData
import com.yandex.mobile.ads.common.MobileAds
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity_ApComAct() {

    lateinit var handler: Handler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        handler = Handler()

        setUpPreference()
        setUpPreferenceTwo()
        my_search_frame.visibility = View.GONE
        my_info_frame.visibility = View.GONE
        setUpBottomNavigationMenu()

        my_testResult_frame.visibility = View.VISIBLE

        initMobileAdsYandex()
        loadAndShowBanner()


       //Log.d("MyLog", "OnCreate MainActivity state: ${dataModel.stateOpenTestAnimal.value.toString()}")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MyLog", "OnResume MainActivity state: ${dataModel.stateOpenTestAnimal.value.toString()}")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("MyLog", "OnActivityResult MainActivity")
        if (requestCode == 100 && resultCode == Activity.RESULT_OK && data != null) {
            val f_n = data.getIntExtra("first_name", -1)
            val f_v = data.getIntExtra("first_volume", -1)
            val s_n = data.getIntExtra("second_name", -1)
            val s_v = data.getIntExtra("second_volume", -1)
            val l_n = data.getIntExtra("last_name", -1)
            val a_v = data.getIntExtra("all_volume", -1)

            dataModel.resultTotemTest.value?.clear()
            dataModel.resultTotemTest.value?.add(f_n)
            dataModel.resultTotemTest.value?.add(f_v)
            dataModel.resultTotemTest.value?.add(s_n)
            dataModel.resultTotemTest.value?.add(s_v)
            dataModel.resultTotemTest.value?.add(l_n)
            dataModel.resultTotemTest.value?.add(a_v)
            dataModel.stateOpenTestAnimal.value = 1

            dataModel.saveResultsToPreference(this)

            Log.d("MyLog", "onActivityResult Animals Result:  $f_n $f_v $s_n $s_v $l_n $a_v ")
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.my_testResult_frame,
                    fragment_testResult.newInstance()
                ).commit()
        } else if (requestCode == 200 && resultCode == Activity.RESULT_OK && data != null) {
            val vataValue = data.getIntExtra("dosha_vata", 1)
            val pittaValue = data.getIntExtra("dosha_pitta", 1)
            val kaphaValue = data.getIntExtra("dosha_kapha", 1)

            dataModel.resultDoshaTest.value?.clear()
            dataModel.resultDoshaTest.value?.add(vataValue)
            dataModel.resultDoshaTest.value?.add(pittaValue)
            dataModel.resultDoshaTest.value?.add(kaphaValue)
            dataModel.stateOpenTestAnimal.value = 2

            dataModel.saveResultsToPreference(this)

            Log.d("MyLog", "onActivityResult Doshas Result:  $vataValue , $pittaValue , $kaphaValue ")
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.my_testResult_frame,
                    fragment_testResult.newInstance()
                ).commit()
        } else {
            Log.d(
                "MyLog",
                " OnActivityResult : НЕ requestCode==100 200 && resultCode==Activity.RESULT_OK && data!=null "
            )
        }
    }

    var double_back_press = false
    override fun onBackPressed() {

        if (double_back_press == true) {
            super.onBackPressed()
        }
        double_back_press = true
        handler.postDelayed({ double_back_press = false }, 2000)

        val aDialog = AlertDialog.Builder(this)
        aDialog.apply {
            setMessage(R.string.Alert_message_exit)
                .setCancelable(true)
                .setPositiveButton(
                    R.string.Alert_yes,
                    DialogInterface.OnClickListener { dialog, id -> super.onBackPressed() })
        }
        aDialog.setNegativeButton(
            R.string.Alert_no,
            DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })

        val alert = aDialog.create()
        alert.show()


    }

    fun initMobileAdsYandex() {
        MobileAds.initialize(this) { Log.d("MyLog", "SDK Initialised OK") }
    }

    fun loadAndShowBanner() {
        adViewYandex.apply {
            setAdUnitId(getString(R.string.yandex_banner_id))
            setAdSize(AdSize.BANNER_320x50)
        }
        val adRequest = AdRequest.Builder().build()

        adViewYandex.setBannerAdEventListener(object : BannerAdEventListener {
            override fun onAdLoaded() {
                Log.d("MyLog", "Ad Loaded Ok")
            }

            override fun onAdFailedToLoad(p0: AdRequestError) {
                Log.d("MyLog", "Banner Ad Load Fail")
            }

            override fun onAdClicked() {
                Log.d("MyLog", "Ad Clicked")
            }

            override fun onLeftApplication() {
            }

            override fun onReturnedToApplication() {
            }

            override fun onImpression(p0: ImpressionData?) {
            }
        })
        adViewYandex.loadAd(adRequest)
    }

}


