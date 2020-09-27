package com.yzp.mvvmlibrary.base

import android.app.Application
import android.content.Context
import com.yzp.mvvmlibrary.app.GlobalConfig
import com.yzp.mvvmlibrary.app.MVVM

/**
 */
open class BaseApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MVVM.install(GlobalConfig().apply {
            viewModelFactory = ViewModelFactory()
        })
    }
}