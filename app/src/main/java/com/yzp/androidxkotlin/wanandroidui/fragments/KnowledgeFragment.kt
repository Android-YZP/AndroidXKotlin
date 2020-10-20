package com.yzp.androidxkotlin.wanandroidui.fragments

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.GsonUtils
import com.orhanobut.logger.Logger
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.bean.DataY
import com.yzp.androidxkotlin.wanandroidui.adapter.HomeAdapter
import com.yzp.androidxkotlin.viewmodel.WanMainViewModel
import com.yzp.androidxkotlin.wanandroidui.adapter.SquareAdapter
import com.yzp.mvvmlibrary.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_knowledge.*
import kotlinx.android.synthetic.main.fragment_question.*
import kotlinx.android.synthetic.main.fragment_wan_home.*

//广场
class KnowledgeFragment : BaseFragment<WanMainViewModel, ViewDataBinding>() {
    var mPage = 0;
    private var data = ArrayList<DataY>()
    private val mAdapter by lazy { SquareAdapter(data) }

    override fun layoutId(): Int = R.layout.fragment_knowledge

    override fun lazyLoadData() {
        with(rv_knowledge) {
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            adapter = mAdapter
        }
        getSquareData()
    }

    override fun initListener() {

        rl_knowledge.setOnRefreshListener {
            mPage = 0
            viewModel.getSquareData(mPage, false)
        }

        rl_knowledge.setOnLoadMoreListener {
            mPage++
            viewModel.getSquareData(mPage, false)
        }

    }

    private fun getSquareData() {
        viewModel.getSquareData(mPage, true).observe(this, Observer {
            with(rl_knowledge) {
                if (isRefreshing) {
                    mAdapter.data.clear()
                    finishRefresh(100)
                }
                if (isLoading) finishLoadMore(100)
            }

            if (it.data.pageCount <= mPage) {
                rl_knowledge.setNoMoreData(true)
                return@Observer
            }
            mAdapter.data.addAll(it.data.datas)
            mAdapter.notifyDataSetChanged()
        })
    }

    private fun setErrorView() {
        val errorView: View =
            layoutInflater.inflate(R.layout.list_error_view, null, false)
        errorView.setOnClickListener {
            mPage = 0;
            viewModel.getSquareData(mPage, true)
        }
        mAdapter.setEmptyView(errorView)
    }

    override fun handleEvent(msg: String) {
        setErrorView()
        with(rl_knowledge) {
            if (isRefreshing) finishRefresh(100)
            if (isLoading) finishLoadMore(100)
        }
    }
}