package com.yzp.androidxkotlin.ui.databinding

import androidx.databinding.BaseObservable

class UserBean(userName: String?, password: String?) : BaseObservable() {
    private var userName: String? = null
    private var password: String? = null

    init {
        this.password = password
        this.userName = userName
    }

    fun getUserName(): String? {
        return userName
    }

    fun setUserName(userName: String?) {
        this.userName = userName
        notifyChange()
    }

    fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String?) {
        this.password = password
        notifyChange()
    }

}