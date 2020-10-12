package com.yzp.androidxkotlin.wanandroidui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.LogUtils
import com.google.gson.Gson
import com.yzp.androidxkotlin.ui.banner.BannerBean
import com.yzp.androidxkotlin.base.BaseResult
import com.yzp.androidxkotlin.repository.HomeRepository
import com.yzp.androidxkotlin.repository.WanAndroidRepository
import com.yzp.mvvmlibrary.base.BaseViewModel
import com.yzp.mvvmlibrary.http.ExceptionHandle
import com.yzp.mvvmlibrary.http.ResponseThrowable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import java.util.*

class LoginViewModel : BaseViewModel() {

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