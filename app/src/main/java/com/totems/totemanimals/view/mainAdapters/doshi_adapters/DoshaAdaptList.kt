package com.totems.totemanimals.view.mainAdapters.doshi_adapters

import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.totems.totemanimals.R
import com.totems.totemanimals.resoursesTests.List_Resours_RCview_Doshi
import kotlinx.android.synthetic.main.fragment_main_search.view.*

class DoshaAdaptList(var onItemClick: ((ShablonDoshaDataClass) -> Unit)? = null) :
    RecyclerView.Adapter<DoshaAdaptList.DoshaHolder>() {

    val handler = Handler()
    val listDoshas = ArrayList<ShablonDoshaDataClass>()

    inner class DoshaHolder(view : View) : RecyclerView.ViewHolder(view){
        val image : ImageView = view.findViewById(R.id.im_item_shablon)
        val title : TextView = view.findViewById(R.id.tv_item_shablon)

        fun bind(shablonDosha: ShablonDoshaDataClass){
            title.textSize = 11f
            title.text = shablonDosha.title
            image.setImageResource(shablonDosha.image)
        }
        init {
            view.setOnClickListener { onItemClick?.invoke(listDoshas[adapterPosition]) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoshaAdaptList.DoshaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rc_desc_shablon_xml, parent, false)
            return DoshaHolder(view)
    }


    override fun onBindViewHolder(holder: DoshaAdaptList.DoshaHolder, position: Int) {
        holder.itemView.alpha = 0f
        holder.bind(listDoshas[position])
        holder.run {
            handler.postDelayed(
                {
                    itemView.setAnimationInsert()
                }, 0
            )
        }
    }

    override fun getItemCount(): Int {
        return listDoshas.size
    }

    fun View.setAnimationInsert() {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 1500
        this.startAnimation(anim)
        this.alpha = 1f
    }


    fun addAllDoshaDescrOnRV(view: View, resoursList: ArrayList<ShablonDoshaDataClass>) {
        if (List_Resours_RCview_Doshi.imIdList.count() != view.rcView_Doshas.layoutManager?.itemCount) {
            var index = 0
            for (i in resoursList) {
                listDoshas.add(i)
                index++
            }
        }
    }
}