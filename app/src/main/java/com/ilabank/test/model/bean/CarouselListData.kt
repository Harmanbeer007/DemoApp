package com.ilabank.test.model.bean

import androidx.annotation.DrawableRes

data class CarouselListData(
    val carouselId: Int,
    val carouselDataId: Int,
    @DrawableRes val image: Int,
    val label: String
)