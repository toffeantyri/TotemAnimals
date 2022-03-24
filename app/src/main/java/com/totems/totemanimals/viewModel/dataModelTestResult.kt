package com.totems.totemanimals.viewModel

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.preference.PreferenceManager

class DataModelTestResult : ViewModel() {

    val stateOpenTestAnimal: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    private val listAnimals = MutableLiveData<ArrayList<Int>>()
    val resultTotemTest: MutableLiveData<ArrayList<Int>> by lazy {
        listAnimals
    }

    private val listDoshas = MutableLiveData<ArrayList<Int>>()
    val resultDoshaTest: MutableLiveData<ArrayList<Int>> by lazy {
        listDoshas
    }


    init {
        Log.d("MyLog", "Init LiveData")
        listDoshas.value = arrayListOf()
        listAnimals.value = arrayListOf()
    }

    fun saveResultsToPreference(context: Context){
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        if (listAnimals.value != null) {
            pref.edit().putInt("first_name", listAnimals.value!![0]).apply()
            pref.edit().putInt("first_volume", listAnimals.value!![1]).apply()
            pref.edit().putInt("second_name", listAnimals.value!![2]).apply()
            pref.edit().putInt("second_volume", listAnimals.value!![3]).apply()
            pref.edit().putInt("last_name", listAnimals.value!![4]).apply()
            pref.edit().putInt("all_volume", listAnimals.value!![5]).apply()
        }
        if (listDoshas.value != null){
            pref.edit().putInt("dosha_vata", listDoshas.value!![0]).apply()
            pref.edit().putInt("dosha_pitta", listDoshas.value!![1]).apply()
            pref.edit().putInt("dosha_kapha", listDoshas.value!![2]).apply()
        }
    }

}