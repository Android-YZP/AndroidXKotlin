package com.yzp.androidxkotlin.wanandroidui

import android.os.Bundle
import android.text.TextUtils
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.ui.net.NetViewModel
import com.yzp.mvvmlibrary.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginViewModel, ViewDataBinding>() {

    override fun layoutId(): Int = R.layout.activity_login

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun initData() {
        login_submit.setOnClickListener {
            if (TextUtils.isEmpty(login_username_edit.text.toString()) &&
                TextUtils.isEmpty(login_password_edit.text.toString())
            ) {
                ToastUtils.showShort("账号密码不能为空")
                return@setOnClickListener
            }
            login()
        }
    }


    private fun login() {
        viewModel.login(
            login_username_edit.text.toString(),
            login_password_edit.text.toString()
        ).observe(this, Observer {
            LogUtils.e(GsonUtils.toJson(it.nickname))


        })
    }
}