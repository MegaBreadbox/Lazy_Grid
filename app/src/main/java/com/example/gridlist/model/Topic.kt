package com.example.gridlist.model

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

//needs the components of
data class Topic(
    @StringRes val stringResourceId: Int,
    val integerResource: Int,
    @DrawableRes val imageResourceId: Int,

    )
