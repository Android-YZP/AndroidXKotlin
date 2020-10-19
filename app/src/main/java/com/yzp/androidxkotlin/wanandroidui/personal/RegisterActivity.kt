package com.yzp.androidxkotlin.wanandroidui.personal

import android.os.Bundle
import android.text.TextUtils
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.ToastUtils
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.viewmodel.PersonViewModel
import com.yzp.mvvmlibrary.base.BaseActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity<PersonViewModel, ViewDataBinding>() {

    override fun layoutId(): Int = R.layout.activity_register

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun initData() {
        login_submit.setOnClickListener {
            if (TextUtils.isEmpty(login_username_edit.text.toString()) &&
                TextUtils.isEmpty(login_password_edit.text.toString()) &&
                TextUtils.isEmpty(login_password_edit2.text.toString())){

                ToastUtils.showShort("账号密码不能为空")
                return@setOnClickListener
            }
            register()
        }
    }

    private fun register() {
        viewModel.register(
            login_username_edit.text.toString(),
            login_password_edit.text.toString(),
            login_password_edit2.text.toString(),
        ).observe(this, Observer {
            finish()
        })
    }
}