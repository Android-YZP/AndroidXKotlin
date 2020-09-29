package com.yzp.androidxkotlin.ui.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.yzp.androidxkotlin.R
import com.yzp.mvvmlibrary.base.BaseActivity
import com.yzp.mvvmlibrary.base.NoViewModel

class RoomActivity : BaseActivity<NoViewModel, ViewDataBinding>() {

    override fun layoutId(): Int = R.layout.activity_room

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
    }

}