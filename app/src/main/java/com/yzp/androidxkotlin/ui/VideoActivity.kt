package com.yzp.androidxkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.yzp.androidxkotlin.R
import com.yzp.mvvmlibrary.base.BaseActivity
import com.yzp.mvvmlibrary.base.NoViewModel

class VideoActivity : BaseActivity<NoViewModel, ViewDataBinding>() {

    override fun layoutId(): Int = R.layout.activity_video

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
    }

}