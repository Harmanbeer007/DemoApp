package com.ilabank.test.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.hideKeyboard() {
    val `in`: InputMethodManager =
        this.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    `in`.hideSoftInputFromWindow(this.windowToken, 0)

}