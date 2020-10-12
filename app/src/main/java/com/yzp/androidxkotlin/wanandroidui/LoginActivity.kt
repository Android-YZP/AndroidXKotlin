package com.yzp.androidxkotlin.wanandroidui

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.ui.net.NetViewModel
import com.yzp.mvvmlibrary.base.BaseActivity

class LoginActivity : BaseActivity<NetViewModel, ViewDataBinding>() {

    override fun layoutId(): Int = R.layout.activity_login

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun initData() {

    }
}