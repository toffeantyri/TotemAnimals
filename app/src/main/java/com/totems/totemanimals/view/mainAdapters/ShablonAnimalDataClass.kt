package com.totems.totemanimals.view.mainAdapters

import com.totems.totemanimals.R
import java.io.Serializable

data class ShablonAnimalDataClass(
    override val image: Int,
    override val title: String,
    override val description: String
) : Serializable, ShablonClassDescription() {

    override val backgroundImage: Int = R.drawable.background_test1


}

