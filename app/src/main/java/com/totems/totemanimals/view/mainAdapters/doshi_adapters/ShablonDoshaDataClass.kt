package com.totems.totemanimals.view.mainAdapters.doshi_adapters

import java.io.Serializable
import com.totems.totemanimals.R
import com.totems.totemanimals.view.mainAdapters.ShablonClassDescription

data class ShablonDoshaDataClass(
    override val image: Int,
    override val title: String,
    override val description: String
) : Serializable, ShablonClassDescription() {

    override val backgroundImage: Int = R.drawable.doshi_background
}

