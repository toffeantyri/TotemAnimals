package com.totems.totemanimals

import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.totems.totemanimals.view.mainAdapters.Animal
import com.yandex.mobile.ads.banner.AdSize
import com.yandex.mobile.ads.banner.BannerAdEventListener
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData
import kotlinx.android.synthetic.main.activity_animal_descpt_view.*
import kotlinx.android.synthetic.main.activity_main.*

class Animal_descpt_view : BaseActivity_ApComAct() {

    lateinit var descAnimal_data: Animal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_descpt_view)
        val descAnimal_data1 = intent.getSerializableExtra("description_search") ?: intent.getSerializableExtra("description_result")

        descAnimal_data = descAnimal_data1 as Animal

        Log.d("MyLog", descAnimal_data.toString())

        bindingViewLyout()
        desc_act_btn_back.setOnClickListener{
        finish()
        }


        btn_share_desc_animal.setOnClickListener {
            shareDescAnimal()
        }

        loadAndShowBanner()
    }

    fun bindingViewLyout () {
        desc_act_imTitle.setImageResource(descAnimal_data.im_animal)
        desc_act_tv_title.text = descAnimal_data.title_animal
        desc_act_tv_desc.text = descAnimal_data.disc
    }

    fun shareDescAnimal(){
        val link = getString(R.string.link_on_my_app_for_share)
        val my_totem = if(intent.getSerializableExtra("description_search")==null) {getString(R.string.my_totem_text_result)} else {getString(R.string.my_totem_text_search)}
        val title = descAnimal_data.title_animal + "\n"
        val descr = descAnimal_data.disc


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

    fun loadAndShowBanner() {
        descr_banner_yandex.apply {
            setAdUnitId(getString(R.string.yandex_banner_id_test))
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

