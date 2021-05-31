package com.ilabank.test.model.bean

import androidx.annotation.DrawableRes

data class CarouselData(
        val carouselId: Int,
        @DrawableRes val carouselImage: Int,
        val data: List<CarouselListData>
)