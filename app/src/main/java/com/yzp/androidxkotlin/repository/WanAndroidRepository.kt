package com.yzp.androidxkotlin.repository

import android.R.string
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.GsonUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tencent.mmkv.MMKV
import com.yzp.androidxkotlin.api.WanApiService
import com.yzp.androidxkotlin.base.BaseResult
import com.yzp.androidxkotlin.bean.*
import com.yzp.androidxkotlin.http.RetrofitClient
import com.yzp.androidxkotlin.ui.banner.BannerBean
import com.yzp.mvvmlibrary.base.BaseModel


class WanAndroidRepository private constructor(
) : BaseModel() {

    private val mService by lazy { RetrofitClient.getInstance().create(WanApiService::class.java) }


    suspend fun getBannerData(): BaseResult<List<BannerBean>> {
        return mService.getBanner()
    }


    suspend fun getTopAritrilList(): BaseResult<Any> = mService.getTopAritrilList()


    suspend fun getProjecTitle(): BaseResult<Any> {
        return mService.getProjecTitle()
    }


//    suspend fun getProjecDataByType(): BaseResult<Any> {
//        return mService.getProjecDataByType()
//    }

//    suspend fun getProjecNewData(): BaseResult<Any> {
//        return mService.getProjecNewData()
//    }


    suspend fun getPublicTitle(): BaseResult<Any> {
        return mService.getPublicTitle()
    }


//    suspend fun getPublicData(): BaseResult<Any> {
//        return mService.getPublicData()
//    }


    suspend fun getSearchData(): BaseResult<Any> {
        return mService.getSearchData()
    }

//    suspend fun getSearchDataByKey(): BaseResult<Any> {
//        return mService.getSearchDataByKey()
//    }

    suspend fun getSquareData(page: Int): BaseResult<SquareBean> {
        return mService.getSquareData(page)
    }

//    suspend fun getAskData(): BaseResult<Any> {
//        return mService.getAskData()
//    }

    suspend fun getSystemData(): BaseResult<List<SystemBean>> {
        val s = MMKV.defaultMMKV().getString("getSystemData", "")
        return if (s.isNullOrEmpty()) {
            mService.getSystemData()
        } else {
            BaseResult<List<SystemBean>>("", 0,
                GsonUtils.fromJson(s, object : TypeToken<List<SystemBean?>?>() {}.type))
        }
    }

//    suspend fun getSystemChildData(): BaseResult<Any> {
//        return mService.getSystemChildData()
//    }

    suspend fun getNavigationData(isRefresh: Boolean): BaseResult<List<NaviBean>> {
        val s = MMKV.defaultMMKV().getString("getNavigationData", "")
        return if (s.isNullOrEmpty()) {
            mService.getNavigationData()
        } else {
            BaseResult<List<NaviBean>>("", 0,
                GsonUtils.fromJson(s, object : TypeToken<List<NaviBean?>?>() {}.type))
        }
    }

//    suspend fun collect(): BaseResult<Any> {
//        return mService.collect()
//    }

//    suspend fun uncollect(): BaseResult<Any> {
//        return mService.uncollect()
//    }
//
//    suspend fun collectUrl(): BaseResult<Any> {
//        return mService.collectUrl()
//    }
//
//    suspend fun deletetool(): BaseResult<Any> {
//        return mService.deletetool()
//    }
//
//
//    suspend fun getCollectData(): BaseResult<Any> {
//        return mService.getCollectData()
//    }


    suspend fun getCollectUrlData(): BaseResult<Any> {
        return mService.getCollectUrlData()
    }

//
//    suspend fun getShareByidData(): BaseResult<Any> {
//        return mService.getShareByidData()
//    }
//
//
//    suspend fun getIntegral(): BaseResult<Any> {
//        return mService.getIntegral()
//    }

//    suspend fun getIntegralRank(): BaseResult<Any> {
//        return mService.getIntegralRank()
//    }

//    suspend fun getIntegralHistory(): BaseResult<Any> {
//        return mService.getIntegralHistory()
//    }

//    suspend fun getShareData(): BaseResult<Any> {
//        return mService.getShareData()
//    }

//    suspend fun deleteShareData(): BaseResult<Any> {
//        return mService.deleteShareData()
//    }

//    suspend fun addAriticle(): BaseResult<Any> {
//        return mService.addAriticle()
//    }

//    suspend fun addTodo(): BaseResult<Any> {
//        return mService.addTodo()
//    }

//    suspend fun updateTodo(): BaseResult<Any> {
//        return mService.updateTodo()
//    }

    suspend fun deleteTodo(id: Int): BaseResult<Any> {
        return mService.deleteTodo(id)
    }

    suspend fun doneTodo(id: Int, status: Int): BaseResult<Any> {
        return mService.doneTodo(id, status)
    }

    suspend fun getQuestionList(page: Int): BaseResult<QuestionBean> {
        return mService.getQuestionList(page)
    }

    suspend fun getArticleList(page: Int): BaseResult<HomeBean> {
        return mService.getArticleList(page)
    }

    suspend fun login(username: String, password: String): BaseResult<LoginBean> {
        return mService.login(username, password)
    }

    suspend fun register(username: String, password: String, password2: String): BaseResult<Any> {
        return mService.register(username, password, password2)
    }

    companion object {
        @Volatile
        private var INSTANCE: WanAndroidRepository? = null
        fun getInstance() =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: WanAndroidRepository().also { INSTANCE = it }
            }
    }


}