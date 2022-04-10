package com.totems.totemanimals.view

import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.totems.totemanimals.R
import com.totems.totemanimals.view.mainAdapters.ShablonClassDescription
import com.yandex.mobile.ads.banner.AdSize
import com.yandex.mobile.ads.banner.BannerAdEventListener
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData
import kotlinx.android.synthetic.main.activity_animal_descpt_view.*

class ActivityDescptView : BaseActivity_ApComAct() {

    var description_data: ShablonClassDescription = ShablonClassDescription()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_descpt_view)
        val desc_data0 = intent.getSerializableExtra(description_data.INTENT_KEY_SEARCH) ?: intent.getSerializableExtra(description_data.INTENT_KEY_RESULT)

        description_data = desc_data0 as ShablonClassDescription

        const_layout_main_cont_descr.background = getDrawable(description_data.backgroundImage)

        //Log.d("MyLog", description_data.toString())

        bindingViewLyout()
        desc_act_btn_back.setOnClickListener{
        finish()
        }


        btn_share_desc_animal.setOnClickListener {
            shareDescAnyClass()
        }

        loadAndShowBanner()
    }

    fun bindingViewLyout () {
        desc_act_imTitle.setImageResource(description_data.image)
        desc_act_tv_title.text = description_data.title
        desc_act_tv_desc.text = description_data.description
    }

    fun shareDescAnyClass(){
        val link = getString(R.string.link_on_my_app_for_share)
        val my_totem = if(intent.getSerializableExtra(description_data.INTENT_KEY_RESULT)==null) {getString(
            R.string.my_totem_text_result
        )} else {getString(R.string.my_totem_text_search)}
        val title = description_data.title + "\n"
        val descr = description_data.description


        val intent = Intent()
        intent.setAction(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT, link + "\n" + my_totem +  title + "\n" + descr )
        intent.setType("text/plain")
        Log.d("MyLog", link  + "\n " + my_totem + title +"\n " + descr)
        startActivity(Intent.createChooser(intent, getString(R.string.share_totem)))

    }

    //преобразует ресурс Id картинки в Uri
    fun imageToUri(imId: Int): Uri  {
        val image_uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + resources.getResourcePackageName(imId)+
                "/" + resources.getResourceTypeName(imId) +
                "/" + resources.getResourceEntryName(imId))
        return image_uri
    }


    //TODO Description Banner id
    fun loadAndShowBanner() {
        descr_banner_yandex.apply {
            setAdUnitId(getString(R.string.yandex_banner_desc_id_test))
            setAdSize(AdSize.BANNER_320x50)
        }
        val adRequest = AdRequest.Builder().build()

        descr_banner_yandex.setBannerAdEventListener(object : BannerAdEventListener {
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
        descr_banner_yandex.loadAd(adRequest)
    }
}

