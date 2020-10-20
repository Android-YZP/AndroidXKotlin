package com.yzp.androidxkotlin.wanandroidui.fragments

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.GsonUtils
import com.orhanobut.logger.Logger
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.bean.DataY
import com.yzp.androidxkotlin.wanandroidui.adapter.HomeAdapter
import com.yzp.androidxkotlin.viewmodel.WanMainViewModel
import com.yzp.mvvmlibrary.base.BaseFragment

//广场
class KnowledgeFragment : BaseFragment<WanMainViewModel, ViewDataBinding>() {
    var mPage = 0;
    private var data = ArrayList<DataY>()
    private val mHomeAdapter by lazy {
        HomeAdapter(
            data
        )
    }

    override fun layoutId(): Int = R.layout.fragment_knowledge

    override fun lazyLoadData() {
        getSquareData()
    }

    private fun getSquareData() {
        viewModel.getSquareData(mPage, true).observe(this, Observer {
            Logger.e(GsonUtils.toJson(it))

        })
    }
}