package com.yzp.androidxkotlin.repository

import com.yzp.androidxkotlin.api.WanApiService
import com.yzp.androidxkotlin.base.BaseResult
import com.yzp.androidxkotlin.bean.HomeBean
import com.yzp.androidxkotlin.ui.banner.BannerBean
import com.yzp.androidxkotlin.http.RetrofitClient
import com.yzp.androidxkotlin.bean.LoginBean
import com.yzp.androidxkotlin.bean.QuestionBean
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

//    suspend fun getSquareData(): BaseResult<Any> {
//        return mService.getSquareData()
//    }

//    suspend fun getAskData(): BaseResult<Any> {
//        return mService.getAskData()
//    }

    suspend fun getSystemData(): BaseResult<Any> {
        return mService.getSystemData()
    }

//    suspend fun getSystemChildData(): BaseResult<Any> {
//        return mService.getSystemChildData()
//    }

    suspend fun getNavigationData(): BaseResult<Any> {
        return mService.getNavigationData()
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
        return mService.register(username, password,password2)
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