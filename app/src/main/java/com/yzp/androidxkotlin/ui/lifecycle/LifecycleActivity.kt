package com.yzp.androidxkotlin.ui.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yzp.androidxkotlin.R

class LifecycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        //注册需要监听的 Observer
        lifecycle.addObserver(Lifecycle())
    }

}