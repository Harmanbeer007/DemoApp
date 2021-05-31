package com.ilabank.test.model.repo

import com.ilabank.test.R
import com.ilabank.test.model.bean.CarouselData
import com.ilabank.test.model.bean.CarouselListData

class DashboardRepository {

    private val data = mutableListOf<CarouselData>()

    fun dynamicCarouselData(
        carouselCount: Int = 1,
        carouselItemCount: Int = 1
    ): List<CarouselData> {
        data.clear()
        for (i in 1..carouselCount) {
            val temp = mutableListOf<CarouselListData>()
            for (j in 1..carouselItemCount) {
                temp.add(
                    CarouselListData(
                        id = i,
                        carouselDataId = j,
                        image = R.drawable.ic_action_trending,
                        label = "Label ${i.times(10).plus(j)}"
                    )
                )
            }
            data.add(
                CarouselData(
                    carouselId = i,
                    carouselImage = R.mipmap.dummy,
                    data = temp
                )
            )
        }

        return data
    }

}