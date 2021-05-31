package com.ilabank.test.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilabank.test.model.bean.CarouselData
import com.ilabank.test.model.bean.CarouselListData
import com.ilabank.test.model.repo.DashboardRepository
import com.ilabank.test.viewmodels.ConfigConstant.Companion.CAROUSEL_DATA_COUNT
import com.ilabank.test.viewmodels.ConfigConstant.Companion.CAROUSEL_ITEM_DATA_COUNT

class DashboardViewModel : BaseViewModel() {


    private val repository = DashboardRepository()

    private val _carouselData = MutableLiveData<List<CarouselData>>()
    val carouselData: LiveData<List<CarouselData>> = _carouselData

    private val _selectedCarouselListData = MutableLiveData<List<CarouselListData>>()
    val selectedCarouselListData: LiveData<List<CarouselListData>> = _selectedCarouselListData

    init {
        _carouselData.value =
            repository.dynamicCarouselData(CAROUSEL_DATA_COUNT, CAROUSEL_ITEM_DATA_COUNT)
    }

    fun postDataToCarousel(carouselListData: List<CarouselListData>) {
        _selectedCarouselListData.postValue(carouselListData)
    }

    fun getDataWithRespectToPosition(position: Int): List<CarouselListData> {
        return _carouselData.value?.get(position)?.data ?: listOf()
    }
}