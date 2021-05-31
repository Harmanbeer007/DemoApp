package com.ilabank.test

import android.app.Activity
import android.app.Application
import com.ilabank.test.utils.AppLogs

class MyBankingApp : Application() {

    var context: MyBankingApp? = null
    private val TAG: String = MyBankingApp::class.java.simpleName
    var mCurrencyActivity: Activity? = null
    var isBackground: Boolean = true

    companion object {
        var deviceDensity: String = "1x"
        var showEmailDialog: Boolean = true
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }

    /*** function to get device density of user*/
    private fun getDeviceDensity() {
        val scaleDensity = resources.displayMetrics.scaledDensity
        AppLogs.e("SCALE DENSITY", scaleDensity.toString())
        deviceDensity = if (scaleDensity <= 1.00f)
            "1x"
        else if (scaleDensity > 1.00f && scaleDensity <= 1.50f)
            "1.5x"
        else if (scaleDensity > 1.50f && scaleDensity <= 2.00f)
            "2x"
        else if (scaleDensity > 2.00f && scaleDensity <= 3.00f)
            "3x"
        else if (scaleDensity > 3.00f && scaleDensity <= 4.00f)
            "4x"
        else
            "1x"
    }


}