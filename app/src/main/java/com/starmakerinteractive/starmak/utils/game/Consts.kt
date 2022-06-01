package com.starmakerinteractive.starmak.utils.game

import com.starmakerinteractive.starmak.R
import com.starmakerinteractive.starmak.data.model.game.SlotModel

const val SLOT_ANIMATION_DURATION = 100
val randomSlots
    get() = listOf(
        SlotModel(drawableRes = R.drawable.decal_1),
        SlotModel(drawableRes = R.drawable.decal_2),
        SlotModel(drawableRes = R.drawable.decal_3),
        SlotModel(drawableRes = R.drawable.decal_4),
        SlotModel(drawableRes = R.drawable.decal_6),
        SlotModel(drawableRes = R.drawable.decal_7),
        SlotModel(drawableRes = R.drawable.decal_8),
        SlotModel(drawableRes = R.drawable.decal_9),
        SlotModel(drawableRes = R.drawable.decal_10),
        SlotModel(drawableRes = R.drawable.decal_11),
    ).random()