package com.yzp.androidxkotlin.wanandroidui.personal

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.ToastUtils
import com.tencent.mmkv.MMKV
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.ui.main.MainActivity
import com.yzp.androidxkotlin.viewmodel.PersonViewModel
import com.yzp.androidxkotlin.wanandroidui.activitys.WanMainActivity
import com.yzp.mvvmlibrary.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<PersonViewModel, ViewDataBinding>() {

    val kv = MMKV.defaultMMKV();

    override fun layoutId(): Int = R.layout.activity_login

    override fun initView(savedInstanceState: Bundle?) {
        val user = kv.decodeString("User")
        login_username_edit.setText(
            if (kv.decodeString("UserName") == null) "" else kv.decodeString("UserName")
        )
        login_password_edit.setText(
            if (kv.decodeString("PassWord") == null) "" else kv.decodeString("PassWord")
        )
    }


    override fun initData() {
        login_submit.setOnClickListener {
            startActivity(Intent(this@LoginActivity, WanMainActivity::class.java))

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
            kv.encode("User", GsonUtils.toJson(it))
            kv.encode("UserName", login_username_edit.text.toString())
            kv.encode("PassWord", login_password_edit.text.toString())
        })
    }
}