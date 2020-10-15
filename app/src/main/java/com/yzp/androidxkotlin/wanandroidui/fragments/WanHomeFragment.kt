package com.yzp.androidxkotlin.wanandroidui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.yzp.androidxkotlin.R
import com.yzp.mvvmlibrary.base.BaseFragment
import com.yzp.mvvmlibrary.base.NoViewModel


class WanHomeFragment : BaseFragment<NoViewModel, ViewDataBinding>() {

    override fun layoutId(): Int = R.layout.fragment_wan_home

    override fun lazyLoadData() {
        super.lazyLoadData()
    }
}


