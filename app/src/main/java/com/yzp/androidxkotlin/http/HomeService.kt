package com.yzp.androidxkotlin.http

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.*

/**
 *   @auther : Aleyn
 *   time   : 2019/10/29
 */
interface HomeService {

    /**
     * 玩安卓轮播图
     */
    @GET("banner/json")
    suspend fun getBanner(): BaseResult<List<BannerBean>>



    //用户登录
    @POST("jwms-auth/oauth/token")
    suspend  fun login(
        @Header("Authorization") authorization: String?,
        @Header("Content-Type") ContentType: String?,
        @Header("Tenant-Id") TenantId: String?,
        @Query("grant_type") grant_type: String?,
        @Query("username") username: String?,
        @Query("password") password: String?,
        @Query("scope") scope: String?,
        @Query("tenantid") Tenant_id: String?
    ): BaseResult<String>


//
//    /**
//     * 项目列表
//     * @param page 页码，从0开始
//     */
//    @GET("article/listproject/{page}/json")
//    suspend fun getHomeList(@Path("page") page: Int): BaseResult<HomeListBean>
//
//
//    /**
//     * 项目列表
//     * @param page 页码，从0开始
//     */
//    @GET("project/list/{page}/json")
//    suspend fun getProjectList(@Path("page") page: Int, @Query("cid") cid: Int): BaseResult<HomeListBean>
//
//
//    /**
//     * 常用网站
//     */
//    @GET("friend/json")
//    suspend fun getPopularWeb(): BaseResult<MutableList<UsedWeb>>
}