package com.yzp.androidxkotlin.ui.serialport

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.yzp.androidxkotlin.R
import com.yzp.mvvmlibrary.base.BaseActivity
import com.yzp.mvvmlibrary.base.NoViewModel

class SerialPortActivity : BaseActivity<NoViewModel, ViewDataBinding>() {

    override fun layoutId(): Int = R.layout.activity_serialport

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
    }

}