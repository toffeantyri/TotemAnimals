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
import androidx.recyclerview.widget.RecyclerView
import com.totems.totemanimals.ActivityDescptView
import com.totems.totemanimals.R
import com.totems.totemanimals.resoursesTests.List_resours_an_totem
import com.totems.totemanimals.view.mainAdapters.totemanimaladapters.AnimalsAdaptList
import com.totems.totemanimals.view.mainAdapters.totemanimaladapters.ShablonAnimalDataClass
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main_search.*


class MainSearchFragment : Fragment() {
    private val adapter1 = AnimalsAdaptList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { val view0 = inflater.inflate(R.layout.fragment_main_search, container, false)
        return view0
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.initRV()
        adapter1.addAllAnimalOnRV(view, listOfShablonsBuilder() )
    }


    private fun View.initRV() {
        rcView_AnList.layoutManager = GridLayoutManager(activity, 3)
        rcView_AnList.adapter = adapter1
        adapter1.onItemClick = { Animal : ShablonAnimalDataClass ->
            val intent = Intent(activity, ActivityDescptView::class.java)
            intent.putExtra(Animal.INTENT_KEY_SEARCH, Animal)
            startActivity(intent)
        }
    }

    fun listOfShablonsBuilder(): ArrayList<ShablonAnimalDataClass>{
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



    companion object {
       @JvmStatic
        fun newInstance(){}
            }

}
