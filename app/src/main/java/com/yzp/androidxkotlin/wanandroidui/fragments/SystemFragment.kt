package com.yzp.androidxkotlin.wanandroidui.fragments

import androidx.databinding.ViewDataBinding
import com.yzp.androidxkotlin.R
import com.yzp.mvvmlibrary.base.BaseFragment
import com.yzp.mvvmlibrary.base.NoViewModel


class SystemFragment: BaseFragment<NoViewModel, ViewDataBinding>() {

    override fun layoutId(): Int = R.layout.fragment_system

    override fun lazyLoadData() {
        super.lazyLoadData()
    }


}

