package com.totems.totemanimals.view.mainAdapters.totemanimaladapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.totems.totemanimals.R

class AnimalsAdaptList(var onItemClick: ((ShablonAnimalDataClass)->Unit)?=null): RecyclerView.Adapter<AnimalsAdaptList.AnimalHolder>() { // Адаптер с Вью Хольдером


    val animalList = ArrayList<ShablonAnimalDataClass>()

   inner class AnimalHolder(animal_item: View) : RecyclerView.ViewHolder(animal_item) { // вью холдер с параметром вью передадим шаблон)
        val im0 :ImageView = animal_item.findViewById(R.id.im_item_shablon)
        val tv0 :TextView = animal_item.findViewById(R.id.tv_item_shablon)

        //находим в нашем переданном классу вью - картинку и текст
               fun bind(shablonAnimal: ShablonAnimalDataClass) {  // функция присваивает переданные ? картинку и текст
                tv0.text=shablonAnimal.title
                im0.setImageResource(shablonAnimal.image)
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



    fun addAnimal(shablonAnimal: ShablonAnimalDataClass) {
        animalList.add(shablonAnimal)
        notifyDataSetChanged()
    }
interface OnItemClickListener {


}

}