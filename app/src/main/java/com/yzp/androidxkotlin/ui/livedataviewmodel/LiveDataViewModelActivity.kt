package com.yzp.androidxkotlin.ui.livedataviewmodel

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.yzp.androidxkotlin.R
import kotlinx.android.synthetic.main.activity_live_data_view_model.*

class LiveDataViewModelActivity : AppCompatActivity() {

    var viewModel: UserViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_view_model)
        //        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        viewModel = ViewModelProvider(this, NewInstanceFactory()).get(UserViewModel::class.java)

        viewModel!!.initData()
        viewModel!!.userLiveData.observe(this, Observer {
            textView2.text = "${it.name}${it.password}"
        })

        Handler().postDelayed(Runnable {
            viewModel!!.changeUser()
        },1000)
    }


}