package com.yzp.androidxkotlin.repository

import com.yzp.androidxkotlin.api.ApiService
import com.yzp.androidxkotlin.base.BaseResult
import com.yzp.androidxkotlin.ui.banner.BannerBean
import com.yzp.androidxkotlin.http.RetrofitClient
import com.yzp.mvvmlibrary.base.BaseModel
import java.util.*

class WanAndroidRepository private constructor(
) : BaseModel() {

    private val mService by lazy { RetrofitClient.getInstance().create(ApiService::class.java) }


    suspend fun getBannerData(): BaseResult<List<BannerBean>> {
        return mService.getBanner()
    }


    suspend fun getTopAritrilList(): BaseResult<Objects> = mService.getTopAritrilList()


//    suspend fun getAritrilList(): BaseResult<Objects> {
//        return mService.getAritrilList()
//    }

    suspend fun getProjecTitle(): BaseResult<Objects> {
        return mService.getProjecTitle()
    }


//    suspend fun getProjecDataByType(): BaseResult<Objects> {
//        return mService.getProjecDataByType()
//    }

//    suspend fun getProjecNewData(): BaseResult<Objects> {
//        return mService.getProjecNewData()
//    }


    suspend fun getPublicTitle(): BaseResult<Objects> {
        return mService.getPublicTitle()
    }


//    suspend fun getPublicData(): BaseResult<Objects> {
//        return mService.getPublicData()
//    }


    suspend fun getSearchData(): BaseResult<Objects> {
        return mService.getSearchData()
    }

//    suspend fun getSearchDataByKey(): BaseResult<Objects> {
//        return mService.getSearchDataByKey()
//    }

//    suspend fun getSquareData(): BaseResult<Objects> {
//        return mService.getSquareData()
//    }

//    suspend fun getAskData(): BaseResult<Objects> {
//        return mService.getAskData()
//    }

    suspend fun getSystemData(): BaseResult<Objects> {
        return mService.getSystemData()
    }

//    suspend fun getSystemChildData(): BaseResult<Objects> {
//        return mService.getSystemChildData()
//    }

    suspend fun getNavigationData(): BaseResult<Objects> {
        return mService.getNavigationData()
    }

//    suspend fun collect(): BaseResult<Objects> {
//        return mService.collect()
//    }

//    suspend fun uncollect(): BaseResult<Objects> {
//        return mService.uncollect()
//    }
//
//    suspend fun collectUrl(): BaseResult<Objects> {
//        return mService.collectUrl()
//    }
//
//    suspend fun deletetool(): BaseResult<Objects> {
//        return mService.deletetool()
//    }
//
//
//    suspend fun getCollectData(): BaseResult<Objects> {
//        return mService.getCollectData()
//    }


    suspend fun getCollectUrlData(): BaseResult<Objects> {
        return mService.getCollectUrlData()
    }

//
//    suspend fun getShareByidData(): BaseResult<Objects> {
//        return mService.getShareByidData()
//    }
//
//
//    suspend fun getIntegral(): BaseResult<Objects> {
//        return mService.getIntegral()
//    }

//    suspend fun getIntegralRank(): BaseResult<Objects> {
//        return mService.getIntegralRank()
//    }

//    suspend fun getIntegralHistory(): BaseResult<Objects> {
//        return mService.getIntegralHistory()
//    }

//    suspend fun getShareData(): BaseResult<Objects> {
//        return mService.getShareData()
//    }

//    suspend fun deleteShareData(): BaseResult<Objects> {
//        return mService.deleteShareData()
//    }

//    suspend fun addAriticle(): BaseResult<Objects> {
//        return mService.addAriticle()
//    }

//    suspend fun addTodo(): BaseResult<Objects> {
//        return mService.addTodo()
//    }

//    suspend fun updateTodo(): BaseResult<Objects> {
//        return mService.updateTodo()
//    }

    suspend fun deleteTodo(id: Int): BaseResult<Objects> {
        return mService.deleteTodo(id)
    }

    suspend fun doneTodo(id: Int, status: Int): BaseResult<Objects> {
        return mService.doneTodo(id, status)
    }


}