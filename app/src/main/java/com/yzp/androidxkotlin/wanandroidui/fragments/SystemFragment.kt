package com.yzp.androidxkotlin.wanandroidui.fragments

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.LogUtils
import com.orhanobut.logger.Logger
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.bean.DataX
import com.yzp.androidxkotlin.bean.SystemBean
import com.yzp.androidxkotlin.viewmodel.WanMainViewModel
import com.yzp.androidxkotlin.wanandroidui.adapter.HomeHeadAdapter
import com.yzp.androidxkotlin.wanandroidui.adapter.SystemAdapter
import com.yzp.mvvmlibrary.base.BaseFragment
import com.yzp.mvvmlibrary.base.NoViewModel
import kotlinx.android.synthetic.main.fragment_question.*
import kotlinx.android.synthetic.main.fragment_system.*


class SystemFragment: BaseFragment<WanMainViewModel, ViewDataBinding>() {
    private var data = ArrayList<SystemBean>()

    private val mAdapter by lazy { SystemAdapter(data) }

    override fun layoutId(): Int = R.layout.fragment_system

    override fun lazyLoadData() {
        with(rv_system) {
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            adapter = mAdapter
        }
        getSystemData()

    }

    private fun getSystemData() {
        viewModel.getSystemData().observe(this, Observer {
            mAdapter.data.addAll(it.data)
            mAdapter.notifyDataSetChanged()
        })
    }
}

