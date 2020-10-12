package com.yzp.androidxkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import com.yzp.androidxkotlin.ui.banner.BannerBean
import com.yzp.androidxkotlin.base.BaseResult
import com.yzp.androidxkotlin.repository.WanAndroidRepository
import com.yzp.androidxkotlin.wanandroidui.login.LoginBean
import com.yzp.mvvmlibrary.base.BaseViewModel

class PersonViewModel : BaseViewModel() {

    private val wanAndroidRepository by lazy {
        WanAndroidRepository.getInstance()
    }

    private val mBanners = MutableLiveData<BaseResult<List<BannerBean>>>()
    private val mLogin = MutableLiveData<LoginBean>()


    fun getBanner(): MutableLiveData<BaseResult<List<BannerBean>>> {
        launchOnlyResult({
            wanAndroidRepository.getBannerData()
        }, {
            mBanners.value = null
        })
        return mBanners
    }

    fun login(username: String, password: String): MutableLiveData<LoginBean> {
        launchOnlyResult({
           wanAndroidRepository.login(username,password) },{
            mLogin.value = it
        })
        return mLogin
    }




}