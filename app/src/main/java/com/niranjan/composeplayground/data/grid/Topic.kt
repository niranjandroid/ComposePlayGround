package com.niranjan.composeplayground.data.grid

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val name: Int,
    val count: Int,
    @DrawableRes val image: Int
)
