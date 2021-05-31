package com.ilabank.test.utils

import androidx.recyclerview.widget.DiffUtil
import com.ilabank.test.model.bean.CarouselListData

class CarouselListDataItemCallback : DiffUtil.ItemCallback<CarouselListData>() {
    override fun areItemsTheSame(
        oldItem: CarouselListData,
        newItem: CarouselListData
    ): Boolean {
        return oldItem.carouselDataId == newItem.carouselDataId
    }

    override fun areContentsTheSame(
        oldItem: CarouselListData,
        newItem: CarouselListData
    ): Boolean {
        return oldItem == newItem
    }
}