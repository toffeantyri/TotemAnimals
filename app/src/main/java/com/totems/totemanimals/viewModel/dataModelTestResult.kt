package com.totems.totemanimals.viewModel

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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


}