package com.yzp.androidxkotlin.wanandroidui.fragments

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.LogUtils
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.bean.Datas
import com.yzp.androidxkotlin.ui.main.QuestionAdapter
import com.yzp.androidxkotlin.viewmodel.WanMainViewModel
import com.yzp.mvvmlibrary.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_question.*
import kotlinx.android.synthetic.main.fragment_wan_home.*


class QuestionFragment : BaseFragment<WanMainViewModel, ViewDataBinding>() {
    private var data = ArrayList<Datas>()
    private val mAdapter by lazy { QuestionAdapter(data) }
    var mPage = 0;

    override fun layoutId(): Int = R.layout.fragment_question

    override fun lazyLoadData() {
        with(rv_question) {
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            adapter = mAdapter
        }
        getQuestionList()
    }

    override fun initListener() {

        rl_question.setOnRefreshListener {
            mPage = 0
            viewModel.getQuestionList(mPage, false)
        }

        rl_question.setOnLoadMoreListener {
            mPage++
            viewModel.getQuestionList(mPage, false)
        }

    }

    private fun getQuestionList() {
        viewModel.getQuestionList(mPage, true).observe(this, Observer {
            with(rl_question) {
                if (isRefreshing) {
                    mAdapter.data.clear()
                    finishRefresh(100)
                }
                if (isLoading) finishLoadMore(100)
            }

            if (it.data.pageCount <= mPage) {
                rl_question.setNoMoreData(true)
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
            viewModel.getQuestionList(mPage, true)
        }
        mAdapter.setEmptyView(errorView)
    }

    override fun handleEvent(msg: String) {
        setErrorView()
        with(rl_question) {
            if (isRefreshing) finishRefresh(100)
            if (isLoading) finishLoadMore(100)
        }
    }
}

