package com.yzp.androidxkotlin.wanandroidui.fragments

import android.content.Intent
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.bean.DataX
import com.yzp.androidxkotlin.bean.HomeBean
import com.yzp.androidxkotlin.ui.main.HomeAdapter
import com.yzp.androidxkotlin.ui.main.MainAdapter
import com.yzp.androidxkotlin.ui.main.MainBean
import com.yzp.androidxkotlin.ui.net.NetActivity
import com.yzp.androidxkotlin.viewmodel.WanMainViewModel
import com.yzp.mvvmlibrary.base.BaseFragment
import com.yzp.mvvmlibrary.base.NoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_wan_home.*


class WanHomeFragment : BaseFragment<WanMainViewModel, ViewDataBinding>() {

    var mPage = 0;
    private var data = ArrayList<DataX>()
    private val mHomeAdapter by lazy { HomeAdapter(data) }

    override fun layoutId(): Int = R.layout.fragment_wan_home

    override fun lazyLoadData() {
        super.lazyLoadData()

        with(rv_home) {
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            adapter = mHomeAdapter
        }
        viewModel.getBanner().observe(this, Observer {

        })


        getHomeList()

    }


    override fun initListener() {
        mHomeAdapter.setOnItemClickListener(OnItemClickListener { adapter, view, position ->

        })

        rl_home.setOnRefreshListener {
            mPage = 0;
            viewModel.getHomeList(mPage)
        }

        rl_home.setOnLoadMoreListener {
            mPage++;
            viewModel.getHomeList(mPage)
        }
    }

    private fun getHomeList() {
        viewModel.getHomeList(mPage).observe(this, Observer {
            rl_home.finishRefresh(100)
            rl_home.finishLoadMore(100)
            if (it.data.datas.isEmpty()) {
                rl_home.setNoMoreData(true)
                return@Observer
            }
            data.addAll(it.data.datas)
            mHomeAdapter.notifyDataSetChanged()
        })
    }

}


