package com.totems.totemanimals.view.mainAdapters

import java.io.Serializable

data class ShablonDoshaDataClass(override val image: Int, override val title: String, override val description: String) : Serializable, ShablonClassDescription(){

}