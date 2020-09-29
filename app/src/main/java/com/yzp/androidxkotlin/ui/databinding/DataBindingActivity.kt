package com.yzp.androidxkotlin.ui.databinding

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDataBindingBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        var user = UserBean("张三111", "哈哈哈哈哈")
        binding.user = user
        Handler().postDelayed(Runnable {
            user.setUserName("哈哈哈哈哈")
            user.setPassword("张三111")
        }, 1000)
    }
}