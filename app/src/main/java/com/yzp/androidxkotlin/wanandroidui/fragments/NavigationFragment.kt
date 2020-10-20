package com.yzp.androidxkotlin.wanandroidui.fragments

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.GsonUtils
import com.tencent.mmkv.MMKV
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.bean.NaviBean
import com.yzp.androidxkotlin.viewmodel.WanMainViewModel
import com.yzp.androidxkotlin.wanandroidui.adapter.NaviAdapter
import com.yzp.mvvmlibrary.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_navigation.*



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

    override fun initListener() {
        srl.setOnRefreshListener {
            viewModel.getNavigationData(true)
        }
    }

    private fun getNavigationData() {
        viewModel.getNavigationData(false).observe(this, Observer {
            if (srl.isRefreshing) srl.finishRefresh(100)
            MMKV.defaultMMKV().putString("getNavigationData", GsonUtils.toJson(it.data))
            mAdapter.data.addAll(it.data)
            mAdapter.notifyDataSetChanged()
        })
    }

    override fun handleEvent(msg: String) {
        if (srl.isRefreshing) srl.finishRefresh(100)
    }
}