package com.ilabank.test.view.splash

import android.view.View
import androidx.databinding.ViewDataBinding
import com.ilabank.test.R
import com.ilabank.test.databinding.FragmentSplashBinding
import com.ilabank.test.view.base.BaseActivity
import com.ilabank.test.view.base.BaseFragment
import com.ilabank.test.viewmodels.ConfigConstant.Companion.SPLASH_DELAY
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment() {


    private lateinit var mSplashBinding: FragmentSplashBinding
    private val mainScope = CoroutineScope(Dispatchers.Main)

    override fun getLayoutId(): Int {
        return R.layout.fragment_splash

    }

    override fun onViewsInitialized(binding: ViewDataBinding, view: View) {
        mSplashBinding = binding as FragmentSplashBinding
    }

    override fun onResume() {
        super.onResume()
        (activity as BaseActivity).supportActionBar?.hide()
        goToHomePage()
    }

    private fun goToHomePage() {
        mainScope.launch {
            mSplashBinding.ivLogo.postDelayed({
                switchToPage(R.id.action_splash_to_dashboardFragment)
            }, SPLASH_DELAY)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}