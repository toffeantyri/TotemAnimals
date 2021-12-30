package com.example.totemanimals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_animal_descpt_view.*
import java.io.Serializable

class Animal_descpt_view : BaseActivity_ApComAct() {

    lateinit var descAnimal_data: Animal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_descpt_view)
        descAnimal_data = intent.getSerializableExtra("description_search") as Animal
        bindingViewLyout()
        desc_act_btn_back.setOnClickListener{
        finish()
        }

    }

    fun bindingViewLyout () {
        desc_act_imTitle.setImageResource(descAnimal_data.im_animal)
        desc_act_tv_title.text = descAnimal_data.title_animal
        desc_act_tv_desc.text = descAnimal_data.disc
    }
}
