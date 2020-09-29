package com.yzp.androidxkotlin.ui.livedataviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    lateinit var userLiveData: MutableLiveData<User>

    /**
     * 初始化数据
     */
    fun initData() {
        userLiveData = MutableLiveData<User>()
        userLiveData.setValue(User("我是初始化数据", "11111111111111"))
    }

    /**
     * 数据改变
     */
    fun changeUser() {
        userLiveData.setValue(User("数据改变", "2222222222222"))
    }
}

