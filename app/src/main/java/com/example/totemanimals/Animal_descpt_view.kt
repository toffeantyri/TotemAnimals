package com.example.totemanimals

import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import com.google.android.material.internal.ParcelableSparseArray
import kotlinx.android.synthetic.main.activity_animal_descpt_view.*
import java.io.Serializable

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

    }

    fun bindingViewLyout () {
        desc_act_imTitle.setImageResource(descAnimal_data.im_animal)
        desc_act_tv_title.text = descAnimal_data.title_animal
        desc_act_tv_desc.text = descAnimal_data.disc
    }

    fun shareDescAnimal(){
        val link = getString(R.string.link_on_my_app_for_share)
        val pic = imageToUri(descAnimal_data.im_animal)
        val my_totem = getString(R.string.my_totem_text)
        val title = descAnimal_data.title_animal + "\n"
        val descr = descAnimal_data.disc


        val intent = Intent()
        intent.setAction(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_STREAM, pic )
        intent.putExtra(Intent.EXTRA_TEXT, link + "\n" + my_totem +  title + "\n" + descr )
        intent.setType("image/*")
        Log.d("MyLog", link +"\n " + pic +"\n " + my_totem + title +"\n " + descr)
        startActivity(Intent.createChooser(intent, "Рассказать о своём тотемном животном:"))

    }

    //преобразует ресурс Id картинки в Uri
    fun imageToUri(imId: Int): Uri  {
        val image_uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + resources.getResourcePackageName(imId)+
                "/" + resources.getResourceTypeName(imId) +
                "/" + resources.getResourceEntryName(imId))
        return image_uri
    }
}

