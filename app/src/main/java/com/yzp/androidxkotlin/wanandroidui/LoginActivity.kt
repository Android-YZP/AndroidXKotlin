package com.yzp.androidxkotlin.wanandroidui

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.ui.home.HomeViewModel
import com.yzp.mvvmlibrary.base.BaseActivity

class LoginActivity : BaseActivity<HomeViewModel, ViewDataBinding>() {

    override fun layoutId(): Int = R.layout.activity_login

    override fun initView(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun initData() {
        TODO("Not yet implemented")
    }
}