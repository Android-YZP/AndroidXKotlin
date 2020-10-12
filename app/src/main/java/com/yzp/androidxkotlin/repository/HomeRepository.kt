package com.yzp.androidxkotlin.repository

import com.yzp.androidxkotlin.api.ApiService
import com.yzp.androidxkotlin.base.BaseResult
import com.yzp.androidxkotlin.bean.BannerBean
import com.yzp.androidxkotlin.http.*
import com.yzp.mvvmlibrary.base.BaseModel


/**
 */
class HomeRepository private constructor(
) : BaseModel() {

    private val mService by lazy { RetrofitClient.getInstance().create(ApiService::class.java) }

    suspend fun getBannerData(): BaseResult<List<BannerBean>> {
        return mService.getBanner()
    }


    suspend fun login(): BaseResult<String> {
        return mService.login(
            Authorization.getInstance().getAuthorization(),
            Authorization.getInstance().getContentType(),
            "475335",
            "password",
            "yzp",
            HexUtil.md5("123456"),
            "all",
            "475335"
        )
    }


    companion object {
        @Volatile
        private var INSTANCE: HomeRepository? = null
        fun getInstance() =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: HomeRepository().also { INSTANCE = it }
            }
    }
}