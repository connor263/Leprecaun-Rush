package com.starmakerinteractive.starmak.data.model

import androidx.annotation.DrawableRes

data class SlotModel(
    var id: Int = -1,
    var key: Int = 1,
    @DrawableRes
    val drawableRes: Int,
    var isMatch: Boolean = false
)