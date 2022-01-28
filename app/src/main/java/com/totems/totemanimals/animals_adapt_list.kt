package com.totems.totemanimals

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_shablon_xml.view.*

class AnimalsAdaptList(var onItemClick: ((Animal)->Unit)?=null): RecyclerView.Adapter<AnimalsAdaptList.AnimalHolder>() { // Адаптер с Вью Хольдером


    val animalList = ArrayList<Animal>()

   inner class AnimalHolder(animal_item: View) : RecyclerView.ViewHolder(animal_item) { // вью холдер с параметром вью передадим шаблон)
        val im0 :ImageView = animal_item.findViewById(R.id.im_item_shablon)
        val tv0 :TextView = animal_item.findViewById(R.id.tv_item_shablon)

        //находим в нашем переданном классу вью - картинку и текст
               fun bind(shablonAnimal: Animal) {  // функция присваивает переданные ? картинку и текст
                tv0.text=shablonAnimal.title_animal
                im0.setImageResource(shablonAnimal.im_animal)
                    }
            init {animal_item.setOnClickListener { onItemClick?.invoke(animalList[adapterPosition]) }
            } // в AnimalAdaptList пришло onItemClick
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.animal_shablon_xml,parent,false)
        return AnimalHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalHolder, position: Int) {
        holder.bind(animalList[position])
    }

    override fun getItemCount(): Int {
       return animalList.size
    }



    fun addAnimal(shablonAnimal: Animal) {
        animalList.add(shablonAnimal)
        notifyDataSetChanged()
    }
interface OnItemClickListener {


}

}