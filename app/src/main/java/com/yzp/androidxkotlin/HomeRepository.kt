package com.yzp.androidxkotlin

import com.yzp.androidxkotlin.http.*
import com.yzp.mvvmlibrary.base.BaseModel


/**
 */
class HomeRepository private constructor(
) : BaseModel() {

    private val mService by lazy { RetrofitClient.getInstance().create(HomeService::class.java) }

    suspend fun getBannerData(): BaseResult<List<BannerBean>> {
        return mService.getBanner()
    }


    suspend fun login(): BaseResult<String> {
        return mService.login(
            Authorization.getInstance().getAuthorization(),
            Authorization.getInstance().getContentType(),
            "000000",
            "password",
            "admin",
            HexUtil.md5("admin"),
            "all",
            "000000"
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