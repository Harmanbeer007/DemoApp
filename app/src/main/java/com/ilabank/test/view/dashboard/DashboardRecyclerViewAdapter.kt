package com.ilabank.test.view.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ilabank.test.databinding.ItemCarouselListingBinding
import com.ilabank.test.model.bean.CarouselListData

class DashboardRecyclerAdapter :
    ListAdapter<CarouselListData,
            DashboardRecyclerAdapter.HomeRecyclerViewHolder>(DiffCallback),
    Filterable {

    var mainList = listOf<CarouselListData>()

    companion object DiffCallback : DiffUtil.ItemCallback<CarouselListData>() {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewHolder {
        return HomeRecyclerViewHolder(
            ItemCarouselListingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomeRecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    fun setOriginalList(data: List<CarouselListData>) {
        mainList = data
        submitList(data)
    }

    class HomeRecyclerViewHolder(private val mBinding: ItemCarouselListingBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun bind(carouselListItemData: CarouselListData) {
            mBinding.carouseListItemData = carouselListItemData
            mBinding.executePendingBindings()
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                var filteredList = mutableListOf<CarouselListData>()

                if (p0.isNullOrEmpty()) {
                    filteredList = mainList.toMutableList()
                } else {
                    for (i in mainList) {
                        if (i.label.contains(p0, ignoreCase = true))
                            filteredList.add(i)
                    }
                }
                return FilterResults().apply { values = filteredList }
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                try {
                    submitList(p1?.values as List<CarouselListData>)
                } catch (e: Exception) {
                    submitList(listOf())
                }
            }

        }
    }
}