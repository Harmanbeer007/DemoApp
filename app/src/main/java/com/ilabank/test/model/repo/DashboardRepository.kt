package com.ilabank.test.model.repo

import com.ilabank.test.R
import com.ilabank.test.model.bean.CarouselData
import com.ilabank.test.model.bean.CarouselListData

class DashboardRepository {

    private val data = mutableListOf<CarouselData>()

    /**
     * Method to generate data for Carousels in HomePage
     *
     * @param carouselCount Defines the number of [CarouselData], default is 1
     * @param carouselItemCount Defines the number of [CarouselListData] in a [CarouselData], default is 1
     *
     * @return Returns a list of Carousel Data after generating a list
     */
    fun generateCarouselData(
        carouselCount: Int = 1,
        carouselItemCount: Int = 1
    ): List<CarouselData> {
        data.clear()
        for (i in 1..carouselCount) {
            val temp = mutableListOf<CarouselListData>()
            for (j in 1..carouselItemCount) {
                temp.add(
                    CarouselListData(
                        carouselId = i,
                        carouselDataId = j,
                        image = R.drawable.ic_action_trending,
                        label = "Label $i.$j"
                    )
                )
            }
            data.add(
                CarouselData(
                    carouselId = i,
                    carouselImage = R.drawable.dummy,
                    data = temp
                )
            )
        }

        return data
    }

}