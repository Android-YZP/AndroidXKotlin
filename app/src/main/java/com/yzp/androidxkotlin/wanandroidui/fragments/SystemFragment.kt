package com.yzp.androidxkotlin.wanandroidui.fragments

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.GsonUtils
import com.tencent.mmkv.MMKV
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.bean.SystemBean
import com.yzp.androidxkotlin.viewmodel.WanMainViewModel
import com.yzp.androidxkotlin.wanandroidui.adapter.SystemAdapter
import com.yzp.mvvmlibrary.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_navigation.*
import kotlinx.android.synthetic.main.fragment_system.*
import kotlinx.android.synthetic.main.fragment_system.rv_system
import kotlinx.android.synthetic.main.fragment_system.srl


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

    override fun initListener() {
        srl.setOnRefreshListener {
            viewModel.getSystemData(true)
        }
    }

    private fun getSystemData() {
        viewModel.getSystemData(false).observe(this, Observer {
            if (srl.isRefreshing) srl.finishRefresh(100)
            MMKV.defaultMMKV().putString("getSystemData", GsonUtils.toJson(it.data))
            mAdapter.data.addAll(it.data)
            mAdapter.notifyDataSetChanged()
        })
    }

    override fun handleEvent(msg: String) {
        if (srl.isRefreshing) srl.finishRefresh(100)
    }
}

