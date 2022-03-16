package com.totems.totemanimals.view.mainAdapters.totemanimaladapters

import com.totems.totemanimals.R
import com.totems.totemanimals.view.mainAdapters.ShablonClassDescription
import java.io.Serializable

data class ShablonAnimalDataClass(
    override val image: Int,
    override val title: String,
    override val description: String
) : Serializable, ShablonClassDescription() {

    override val backgroundImage: Int = R.drawable.background_night


}

