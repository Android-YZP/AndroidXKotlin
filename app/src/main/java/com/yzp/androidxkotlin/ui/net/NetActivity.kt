package com.yzp.androidxkotlin.ui.net

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.LogUtils
import com.google.gson.Gson
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.base.GlobalConfig.BASE_URL_WMS
import com.yzp.mvvmlibrary.base.BaseActivity
import kotlinx.android.synthetic.main.activity_net.*
import me.jessyan.retrofiturlmanager.RetrofitUrlManager

class NetActivity : BaseActivity<NetViewModel, ViewDataBinding>() {

    override fun layoutId(): Int = R.layout.activity_net

    override fun initView(savedInstanceState: Bundle?) {
        with(tv) {
            setTextColor(Color.parseColor("#0000ff"))
            textSize = 18.0f
            setOnClickListener(View.OnClickListener {
                viewModel.getBanner()
            })
        }
    }

    override fun initData() {
        // 改变URL
        RetrofitUrlManager.getInstance().putDomain("douban", BASE_URL_WMS);
        viewModel.getBanner()
            .observe(this, Observer {
                LogUtils.e(Gson().toJson(it))
                tv.text = Gson().toJson(it)
            })

        viewModel.login().observe(this, Observer {
            LogUtils.e(Gson().toJson(it))
            tv.text = Gson().toJson(it)
        })
    }

    override fun handleEvent(msg: String) {
        tv.text = tv.text.toString() + msg
    }
}