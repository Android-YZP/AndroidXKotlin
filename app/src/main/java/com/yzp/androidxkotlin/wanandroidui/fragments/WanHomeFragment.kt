package com.yzp.androidxkotlin.wanandroidui.fragments

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ToastUtils
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.youth.banner.Banner
import com.youth.banner.transformer.ScaleInTransformer
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.bean.DataX
import com.yzp.androidxkotlin.ui.banner.BannerBean
import com.yzp.androidxkotlin.wanandroidui.adapter.HomeAdapter
import com.yzp.androidxkotlin.viewmodel.WanMainViewModel
import com.yzp.androidxkotlin.wanandroidui.adapter.HomeHeadAdapter
import com.yzp.mvvmlibrary.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_wan_home.*


class WanHomeFragment : BaseFragment<WanMainViewModel, ViewDataBinding>() {

    var mPage = 0;
    private var data = ArrayList<DataX>()
    private var dataBanner = ArrayList<BannerBean>()
    private val mHomeAdapter by lazy {
        HomeAdapter(
            data
        )
    }
    private val mHomeHeadAdapter by lazy { HomeHeadAdapter(dataBanner) }

    override fun layoutId(): Int = R.layout.fragment_wan_home

    override fun lazyLoadData() {
        with(rv_home) {
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            adapter = mHomeAdapter

        }

        viewModel.getBanner(!rl_home.isRefreshing).observe(this, Observer {
            if (rl_home.isRefreshing) {
                mHomeHeadAdapter.updateData(it.data)
                viewModel.getHomeList(mPage)
                return@Observer
            }

            //添加头布局
            layoutInflater.inflate(R.layout.head_home, null, false).apply {
                val banner = findViewById<View>(R.id.banner_head) as Banner<*, *>
                with(banner) {
                    addBannerLifecycleObserver(activity)
                    setOrientation(Banner.HORIZONTAL)
                    setPageTransformer(ScaleInTransformer())
                    adapter = mHomeHeadAdapter
                    mHomeHeadAdapter.updateData(it.data)
                }
                mHomeAdapter.addHeaderView(this)
            }
            getHomeList()
        })
    }


    override fun initListener() {
        mHomeAdapter.setOnItemClickListener(OnItemClickListener { adapter, view, position ->
            ToastUtils.showShort(mHomeAdapter.data[position].link)
        })

        rl_home.setOnRefreshListener {
            mPage = 0;
            viewModel.getBanner(!rl_home.isRefreshing)
        }

        rl_home.setOnLoadMoreListener {
            mPage++;
            viewModel.getHomeList(mPage)
        }
    }

    private fun getHomeList() {
        viewModel.getHomeList(mPage).observe(this, Observer {
            with(rl_home) {
                if (isRefreshing) {
                    mHomeAdapter.data.clear()
                    finishRefresh(100)
                }
                if (isLoading) finishLoadMore(100)
            }

            if (it.data.datas.isEmpty()) {
                rl_home.setNoMoreData(true)
                return@Observer
            }
            mHomeAdapter.data.addAll(it.data.datas)
            mHomeAdapter.notifyDataSetChanged()
        })
    }

    private fun setErrorView(){
        val errorView: View =
            layoutInflater.inflate(R.layout.list_error_view, null, false)
        errorView.setOnClickListener {
            mPage = 0;
            viewModel.getBanner(!rl_home.isRefreshing)
        }
        mHomeAdapter.setEmptyView(errorView)
    }

    override fun handleEvent(msg: String) {
        setErrorView()
        with(rl_home) {
            if (isRefreshing) finishRefresh(100)
            if (isLoading) finishLoadMore(100)
        }
    }

}


