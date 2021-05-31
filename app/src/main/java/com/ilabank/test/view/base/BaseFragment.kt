package com.ilabank.test.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment


abstract class BaseFragment : Fragment() {

    private var guide: Unit? = null
    private lateinit var binding: ViewDataBinding

    abstract fun getLayoutId(): Int

    abstract fun onViewsInitialized(binding: ViewDataBinding, view: View)

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Override
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return binding.root
    }

    open fun switchToPage(@IdRes actionID: Int, bundle: Bundle?) {
        NavHostFragment.findNavController(this).navigate(actionID, bundle)
    }

    open fun switchToPage(@IdRes actionID: Int) {
        NavHostFragment.findNavController(this).navigate(actionID)
    }

    open fun switchPage(action: Int) {
        (context as BaseActivity).switchPage(action)
    }

    open fun switchPage(action: Int, bundle: Bundle?) {
        (context as BaseActivity).switchPage(action, bundle)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onViewsInitialized(binding, view)
        super.onViewCreated(view, savedInstanceState)
    }


    fun finish() {
        (activity as BaseActivity).finish()
    }


}