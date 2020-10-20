package com.yzp.androidxkotlin.wanandroidui.fragments

import androidx.databinding.ViewDataBinding
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.viewmodel.WanMainViewModel
import com.yzp.mvvmlibrary.base.BaseFragment
import com.yzp.mvvmlibrary.base.NoViewModel


class QuestionFragment : BaseFragment<WanMainViewModel, ViewDataBinding>() {


    override fun layoutId(): Int = R.layout.fragment_question

    override fun lazyLoadData() {
        super.lazyLoadData()
    }


}

