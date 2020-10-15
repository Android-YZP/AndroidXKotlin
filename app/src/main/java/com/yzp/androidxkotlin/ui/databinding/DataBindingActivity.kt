package com.yzp.androidxkotlin.ui.databinding

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.databinding.ActivityDataBindingBinding
import com.yzp.mvvmlibrary.base.BaseActivity
import com.yzp.mvvmlibrary.base.NoViewModel

class DataBindingActivity : BaseActivity<NoViewModel, ActivityDataBindingBinding>() {
    var user = UserBean("张三111", "哈哈哈哈哈")

    override fun layoutId(): Int = R.layout.activity_data_binding

    override fun initView(savedInstanceState: Bundle?) {
        mBinding!!.user = user
        Handler().postDelayed(Runnable {
            user.setUserName("哈哈哈哈哈")
            user.setPassword("张三111")
        }, 1000)
    }

    override fun initData() {

    }
}