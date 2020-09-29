package com.yzp.androidxkotlin.ui.livedataviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.yzp.androidxkotlin.R
import com.yzp.mvvmlibrary.base.BaseActivity
import com.yzp.mvvmlibrary.base.NoViewModel

class LiveDataViewModelActivity : BaseActivity<NoViewModel, ViewDataBinding>() {

    override fun layoutId(): Int = R.layout.activity_live_data_view_model

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
    }

}