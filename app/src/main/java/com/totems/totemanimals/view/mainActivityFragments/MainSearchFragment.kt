package com.totems.totemanimals.view.mainActivityFragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.totems.totemanimals.ActivityDescptView
import com.totems.totemanimals.R
import com.totems.totemanimals.resoursesTests.List_Resours_RCview_Doshi
import com.totems.totemanimals.resoursesTests.List_resours_an_totem
import com.totems.totemanimals.view.mainAdapters.doshi_adapters.DoshaAdaptList
import com.totems.totemanimals.view.mainAdapters.doshi_adapters.ShablonDoshaDataClass
import com.totems.totemanimals.view.mainAdapters.totemanimaladapters.AnimalsAdaptList
import com.totems.totemanimals.view.mainAdapters.totemanimaladapters.ShablonAnimalDataClass
import com.totems.totemanimals.view.mainQuestion.Animations
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main_search.*
import kotlinx.android.synthetic.main.fragment_main_search.rcView_AnList
import kotlinx.android.synthetic.main.fragment_main_search.rcView_Doshas
import kotlinx.android.synthetic.main.fragment_main_search.view.*


class MainSearchFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(){}
    }
    val animat_var: Animations = Animations()
    private val adapter1 = AnimalsAdaptList()
    private val adapter2 = DoshaAdaptList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { val view0 = inflater.inflate(R.layout.fragment_main_search, container, false)
        return view0
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.initRVAnimals()
        view.initRVDoshas()
        //adapter1.addAllAnimalOnRV(view, listOfShablonsBuilderAnimal() )
        //adapter2.addAllDoshaDescrOnRV(view, listOfShablonsBuilderDosha())
        view.bindAllOpenLists()
    }


    private fun View.initRVAnimals() {
        rcView_AnList.layoutManager = GridLayoutManager(activity, 3)
        rcView_AnList.adapter = adapter1
        adapter1.onItemClick = { Animal : ShablonAnimalDataClass ->
            val intent = Intent(activity, ActivityDescptView::class.java)
            intent.putExtra(Animal.INTENT_KEY_SEARCH, Animal)
            startActivity(intent)
        }
    }

    private fun View.initRVDoshas() {
        rcView_Doshas.layoutManager = GridLayoutManager(activity, 2)
        rcView_Doshas.adapter = adapter2
        adapter2.onItemClick = { Dosha : ShablonDoshaDataClass ->
            val intent = Intent(activity, ActivityDescptView::class.java)
            intent.putExtra(Dosha.INTENT_KEY_SEARCH, Dosha)
            startActivity(intent)
        }
    }

    fun listOfShablonsBuilderAnimal(): ArrayList<ShablonAnimalDataClass>{
        var a: Int
        var b: String
        var c: String
        var animalAdd: ShablonAnimalDataClass
        var index = 0
        val list = arrayListOf<ShablonAnimalDataClass>()
        for (i in List_resours_an_totem.imIdList) {
            a = List_resours_an_totem.imIdList[index]
            b = List_resours_an_totem.nameIdList[index]
            c = List_resours_an_totem.descriptIdList[index]
            animalAdd = ShablonAnimalDataClass(a, b, c)
            list.add(animalAdd)
            index++
        }
        return list
    }

    fun listOfShablonsBuilderDosha(): ArrayList<ShablonDoshaDataClass>{
        var a: Int
        var b: String
        var c: String
        var doshaAdd: ShablonDoshaDataClass
        var index = 0
        val list = arrayListOf<ShablonDoshaDataClass>()
        for (i in List_Resours_RCview_Doshi.imIdList) {
            a = List_Resours_RCview_Doshi.imIdList[index]
            b = List_Resours_RCview_Doshi.nameIdList[index]
            c = List_Resours_RCview_Doshi.descriptIdList[index]
            doshaAdd = ShablonDoshaDataClass(a, b, c)
            list.add(doshaAdd)
            index++
        }
        return list
    }

    fun View.bindAllOpenLists() {
        this.apply {
            btn_linearContainer_open_Animal.setOnClickListener {
               this.openFirstDescriptions()
            }
            btn_open_an_rclist.setOnClickListener {
                this.openFirstDescriptions()
            }

            btn_linearContainer_open_Doshas.setOnClickListener {
                this.openSecondDescriptions()
            }
            btn_open_dosh_rclist.setOnClickListener {
                this.openSecondDescriptions()
            }
        }
    }

    fun View.openFirstDescriptions(){
        adapter1.addAllAnimalOnRV(this, listOfShablonsBuilderAnimal() )
        if(rcView_AnList.visibility == View.GONE) {rcView_AnList.visibility = View.VISIBLE
            btn_open_an_rclist.setImageResource(R.drawable.ic_expand_less_black_32dp)
        animat_var.down_result(this.rcView_AnList)}
        else {rcView_AnList.visibility = View.GONE
            btn_open_an_rclist.setImageResource(R.drawable.ic_expand_more_black_32dp)}

    }

    fun View.openSecondDescriptions(){
        adapter2.addAllDoshaDescrOnRV(this, listOfShablonsBuilderDosha())
        if(rcView_Doshas.visibility == View.GONE) {rcView_Doshas.visibility = View.VISIBLE
            btn_open_dosh_rclist.setImageResource(R.drawable.ic_expand_less_black_32dp)
        animat_var.down_result(this.rcView_Doshas)}
        else {rcView_Doshas.visibility = View.GONE
            btn_open_dosh_rclist.setImageResource(R.drawable.ic_expand_more_black_32dp)}
    }

}
