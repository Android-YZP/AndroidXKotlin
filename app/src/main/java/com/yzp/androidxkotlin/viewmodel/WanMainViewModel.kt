package com.yzp.androidxkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import com.yzp.androidxkotlin.ui.banner.BannerBean
import com.yzp.androidxkotlin.base.BaseResult
import com.yzp.androidxkotlin.bean.*
import com.yzp.androidxkotlin.repository.WanAndroidRepository
import com.yzp.mvvmlibrary.base.BaseViewModel
import com.yzp.mvvmlibrary.base.LoadingDialog

class WanMainViewModel : BaseViewModel() {

    private val wanAndroidRepository by lazy {
        WanAndroidRepository.getInstance()
    }

    private val mBanners = MutableLiveData<BaseResult<List<BannerBean>>>()
    private val mHomeList = MutableLiveData<BaseResult<HomeBean>>()
    private val mQuestionList = MutableLiveData<BaseResult<QuestionBean>>()
    private val mSystemData = MutableLiveData<BaseResult<List<SystemBean>>>()
    private val mSquareData = MutableLiveData<BaseResult<SquareBean>>()


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

    fun getQuestionList(
        page: Int,
        isShowDialog: Boolean
    ): MutableLiveData<BaseResult<QuestionBean>> {
        launchGo({
            mQuestionList.value = wanAndroidRepository.getQuestionList(page)
        }, isShowDialog)
        return mQuestionList
    }

    fun getSystemData(): MutableLiveData<BaseResult<List<SystemBean>>> {
        launchGo({
            mSystemData.value = wanAndroidRepository.getSystemData()
        }, true)
        return mSystemData
    }

    fun getSquareData(page: Int, isShowDialog: Boolean): MutableLiveData<BaseResult<SquareBean>> {
        launchGo({
            mSquareData.value = wanAndroidRepository.getSquareData(page)
        }, isShowDialog)
        return mSquareData
    }


}