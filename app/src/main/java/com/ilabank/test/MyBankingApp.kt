package com.ilabank.test

import android.app.Application

class MyBankingApp : Application() {

    var context: MyBankingApp? = null
    private val TAG: String = MyBankingApp::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        context = this
    }


}