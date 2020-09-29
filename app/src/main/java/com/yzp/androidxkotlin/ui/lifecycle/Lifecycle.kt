package com.yzp.androidxkotlin.ui.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.blankj.utilcode.util.LogUtils

class Lifecycle : ILifecycle {

    override fun onCreate(owner: LifecycleOwner) {
        LogUtils.e("-------onCreate")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        LogUtils.e("-------onDestroy")
    }

    override fun onLifecycleChanged(owner: LifecycleOwner, event: Lifecycle.Event) {

    }
}