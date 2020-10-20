package com.yzp.androidxkotlin.wanandroidui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.GsonUtils
import com.orhanobut.logger.Logger
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.bean.NaviBean
import com.yzp.androidxkotlin.bean.SystemBean
import com.yzp.androidxkotlin.viewmodel.WanMainViewModel
import com.yzp.androidxkotlin.wanandroidui.adapter.NaviAdapter
import com.yzp.androidxkotlin.wanandroidui.adapter.SystemAdapter
import com.yzp.mvvmlibrary.base.BaseFragment
import com.yzp.mvvmlibrary.base.NoViewModel
import kotlinx.android.synthetic.main.fragment_question.*
import kotlinx.android.synthetic.main.fragment_system.*


class NavigationFragment : BaseFragment<WanMainViewModel, ViewDataBinding>() {
    private var data = ArrayList<NaviBean>()

    private val mAdapter by lazy { NaviAdapter(data) }
    override fun layoutId(): Int = R.layout.fragment_navigation

    override fun lazyLoadData() {
        with(rv_system) {
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            adapter = mAdapter
        }
        getNavigationData()
    }

    private fun getNavigationData() {
        viewModel.getNavigationData().observe(this, Observer {
            mAdapter.data.addAll(it.data)
            mAdapter.notifyDataSetChanged()
        })
    }
}