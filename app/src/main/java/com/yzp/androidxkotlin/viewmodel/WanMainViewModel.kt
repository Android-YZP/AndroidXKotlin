package com.yzp.androidxkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import com.yzp.androidxkotlin.ui.banner.BannerBean
import com.yzp.androidxkotlin.base.BaseResult
import com.yzp.androidxkotlin.bean.HomeBean
import com.yzp.androidxkotlin.repository.WanAndroidRepository
import com.yzp.androidxkotlin.bean.LoginBean
import com.yzp.mvvmlibrary.base.BaseViewModel
import com.yzp.mvvmlibrary.base.LoadingDialog

class WanMainViewModel : BaseViewModel() {

    private val wanAndroidRepository by lazy {
        WanAndroidRepository.getInstance()
    }

    private val mBanners = MutableLiveData<BaseResult<List<BannerBean>>>()
    private val mHomeList = MutableLiveData<BaseResult<HomeBean>>()


    fun getBanner(isShowDialog: Boolean): MutableLiveData<BaseResult<List<BannerBean>>> {
        launchGo({
            mBanners.value = wanAndroidRepository.getBannerData()
        }, isShowDialog)
        return mBanners
    }

    fun getHomeList(page: Int): MutableLiveData<BaseResult<HomeBean>> {
        launchGo({
            mHomeList.value = wanAndroidRepository.getArticleList(page)
        }, false)
        return mHomeList
    }


}