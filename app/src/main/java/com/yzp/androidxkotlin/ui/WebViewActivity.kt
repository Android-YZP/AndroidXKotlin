package com.yzp.androidxkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.yzp.androidxkotlin.R
import com.yzp.mvvmlibrary.base.BaseActivity
import com.yzp.mvvmlibrary.base.NoViewModel

class WebViewActivity : BaseActivity<NoViewModel, ViewDataBinding>() {

    override fun layoutId(): Int = R.layout.activity_web_view

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
    }

}