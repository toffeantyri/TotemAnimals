package com.totems.totemanimals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.totems.totemanimals.view.DoshaData
import com.yandex.mobile.ads.banner.AdSize
import com.yandex.mobile.ads.banner.BannerAdEventListener
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData
import kotlinx.android.synthetic.main.activity_animal_descpt_view.*
import kotlinx.android.synthetic.main.activity_doshi_descr_view.*

class DoshiDescrActivityView : AppCompatActivity() {


    lateinit var descDoshaData : DoshaData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doshi_descr_view)

        val takeDescDoshaData = intent.getSerializableExtra("description_dosha") ?: DoshaData(R.drawable.ava_inst1, "Title", "Description")
        descDoshaData = takeDescDoshaData as DoshaData



        bindingViewLyout()
        desc_act_btn_back.setOnClickListener{
            finish()
        }
        btn_share_desc_dosha.setOnClickListener {
            shareDescrDosha()
        }

        loadAndShowBanner()
    }

    fun bindingViewLyout () {
        iv_desc_dosha.setImageResource(descDoshaData.im_dosha)
        tv_title_dosha.text = descDoshaData.title_dosha
        tv_descr_dosha.text = descDoshaData.descr_dosha
    }

    fun loadAndShowBanner() {
        tv_descr_dosha_banner_yandex2.apply {
            setAdUnitId(getString(R.string.yandex_banner_id_test))
            setAdSize(AdSize.BANNER_320x50)
        }
        val adRequest = AdRequest.Builder().build()

        tv_descr_dosha_banner_yandex2.setBannerAdEventListener(object : BannerAdEventListener {
            override fun onAdLoaded() {
                Log.d("MyLogAd", "Ad Loaded Ok")
            }

            override fun onAdFailedToLoad(p0: AdRequestError) {
                Log.d("MyLogAd", "Banner Ad Load Fail")
            }

            override fun onAdClicked() {
                Log.d("MyLogAd", "Ad Clicked")
            }

            override fun onLeftApplication() {
            }

            override fun onReturnedToApplication() {
            }

            override fun onImpression(p0: ImpressionData?) {
            }
        })
        tv_descr_dosha_banner_yandex2.loadAd(adRequest)
    }

    fun shareDescrDosha(){

        val link = getString(R.string.link_on_my_app_for_share)
        val my_dosha = getString(R.string.my_dosha_is)
        val title = descDoshaData.title_dosha + "\n"
        val descr = descDoshaData.descr_dosha

        val intent = Intent()
        intent.setAction(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT, link + "\n" + my_dosha +  title + "\n" + descr )
        intent.setType("text/plain")
        Log.d("MyLog", link  + "\n " + my_dosha + title +"\n " + descr)
        startActivity(Intent.createChooser(intent, getString(R.string.share_totem)))


    }
}
