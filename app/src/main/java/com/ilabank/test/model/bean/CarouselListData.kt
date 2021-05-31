package com.ilabank.test.model.bean

import androidx.annotation.DrawableRes

data class CarouselListData(
    val id: Int,
    val carouselDataId: Int,
    @DrawableRes val image: Int,
    val label: String
)