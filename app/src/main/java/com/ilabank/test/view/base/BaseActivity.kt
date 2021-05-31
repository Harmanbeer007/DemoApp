package com.ilabank.test.view.base

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.Navigation
import com.ilabank.test.BuildConfig
import com.ilabank.test.R
import com.ilabank.test.viewmodels.BaseViewModel

abstract class BaseActivity : AppCompatActivity(), BaseInterFace, LifecycleOwner {

    private val baseViewModel: BaseViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) // To Disable Dark theme by default
        // To Prevent ScreenShot & Screen Recording
        if (!BuildConfig.DEBUG) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE
            )
        }

        val layoutIdRes = layout
        if (layoutIdRes != 0) {
            val binding = DataBindingUtil.setContentView(this, layoutIdRes) as ViewDataBinding
            initUI(binding)

        }

    }

    fun setStatusBarPadding(binding: ViewDataBinding) {
        binding.root.setPadding(0, getStatusBarHeight(), 0, 0)
    }

    private fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId =
            resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    open fun switchPage(action: Int) {
        try {
            val navController = Navigation.findNavController(this, R.id.main_navigation)
            navController.navigate(action)
        } catch (w: Exception) {
        }
    }

    open fun switchPage(action: Int, bundle: Bundle?) {
        try {
            val navController = Navigation.findNavController(this, R.id.main_navigation)
            navController.navigate(action, bundle)
        } catch (w: Exception) {
        }
    }

}
