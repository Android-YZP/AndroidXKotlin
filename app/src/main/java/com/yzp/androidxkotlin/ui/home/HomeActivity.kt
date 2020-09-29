package com.yzp.androidxkotlin.ui.home

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.yzp.androidxkotlin.R
import com.yzp.mvvmlibrary.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity  : BaseActivity<HomeViewModel, ViewDataBinding>() {

    override fun layoutId(): Int = R.layout.activity_home

    override fun initView(savedInstanceState: Bundle?) {
        tv.apply {
            setTextColor(Color.parseColor("#0000ff"))
            setTextSize(18.0f)
            setOnClickListener(View.OnClickListener {
                viewModel.getBanner()
            })
        }
    }

    override fun initData() {
        viewModel.getBanner()
            .observe(this, Observer {
                Log.e("====", Gson().toJson(it))
                tv.text = Gson().toJson(it)
            })
    }

    override fun handleEvent(msg: String) {
        tv.text = tv.text.toString() + msg
    }
}