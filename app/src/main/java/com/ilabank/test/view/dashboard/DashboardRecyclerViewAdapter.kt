package com.ilabank.test.view.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ilabank.test.R
import com.ilabank.test.databinding.ItemCarouselListingBinding
import com.ilabank.test.model.bean.CarouselListData
import com.ilabank.test.utils.CarouselListDataItemCallback
import com.ilabank.test.utils.FilterData

class DashboardRecyclerAdapter(val showEmptyView: (Boolean) -> Unit) :
    ListAdapter<CarouselListData, DashboardRecyclerAdapter.DashboardRecyclerViewHolder>(
        CarouselListDataItemCallback()
    ),
    Filterable {

    var dataList = listOf<CarouselListData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardRecyclerViewHolder {
        val binding = DataBindingUtil.inflate<ItemCarouselListingBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_carousel_listing,
            parent,
            false
        )
        return DashboardRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DashboardRecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    fun setOriginalList(data: List<CarouselListData>) {
        dataList = data
        submitList(data)
    }

    class DashboardRecyclerViewHolder(private val mBinding: ItemCarouselListingBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun bind(carouselListItemData: CarouselListData) {
            mBinding.carouseListItemData = carouselListItemData
            mBinding.executePendingBindings()
        }
    }

    override fun getFilter(): Filter {
        return FilterData<CarouselListData>(dataList) {
            submitList(it)
            showEmptyView(it.isNullOrEmpty())
        }
    }
}

