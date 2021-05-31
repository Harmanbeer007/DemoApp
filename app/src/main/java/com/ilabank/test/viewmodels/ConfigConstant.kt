package com.ilabank.test.viewmodels

import com.ilabank.test.BuildConfig

class ConfigConstant {

    companion object {
        val LOGS_ENABLED = BuildConfig.DEBUG
        const val SPLASH_DELAY = 2000L
        const val CAROUSEL_DATA_COUNT = 5
        const val CAROUSEL_ITEM_DATA_COUNT = 20
    }


}