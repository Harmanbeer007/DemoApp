package com.ilabank.test.view.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.ilabank.test.databinding.ItemCarouselBinding
import com.ilabank.test.model.bean.CarouselData


class DashboardViewPagerAdapter : PagerAdapter() {

    var imagesList: List<CarouselData> = arrayListOf() // list item to hold image array's

    override fun isViewFromObject(view: View, Object: Any): Boolean {
        return view === Object as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding: ItemCarouselBinding =
            ItemCarouselBinding.inflate(LayoutInflater.from(container.context), container, false)

        binding.ivCarousalImage.setImageResource(imagesList[position].carouselImage)
        container.addView(binding.root)
        return binding.root
    }

    override fun getCount(): Int = imagesList.size

    override fun destroyItem(container: ViewGroup, position: Int, Object: Any) {
        container.removeView(Object as ConstraintLayout)
    }

    /* Other functions */
    fun addItems(list: List<CarouselData>) {
        imagesList = list
        notifyDataSetChanged()
    }
}