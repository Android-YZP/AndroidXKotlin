package com.yzp.androidxkotlin.wanandroidui.register

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.viewmodel.PersonViewModel
import com.yzp.mvvmlibrary.base.BaseActivity

class RegisterActivity : BaseActivity<PersonViewModel, ViewDataBinding>() {

    override fun layoutId(): Int =R.layout.activity_register

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun initData() {

    }
}