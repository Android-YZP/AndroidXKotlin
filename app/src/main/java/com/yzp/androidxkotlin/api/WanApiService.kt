package com.yzp.androidxkotlin.api

import com.yzp.androidxkotlin.base.BaseResult
import com.yzp.androidxkotlin.bean.HomeBean
import com.yzp.androidxkotlin.ui.banner.BannerBean
import com.yzp.androidxkotlin.bean.LoginBean
import com.yzp.androidxkotlin.bean.QuestionBean
import retrofit2.http.*

/**
 * 描述　: WanAndroid API
 */
interface WanApiService {

    /**
     * 登录
     */
    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") pwd: String
    ): BaseResult<LoginBean>



    //用户登录
    @Headers("Domain-Name: douban") // Add the Domain-Name header
    @POST("jwms-auth/oauth/token")
    suspend fun login(
        @Header("Authorization") authorization: String?,
        @Header("Content-Type") ContentType: String?,
        @Header("Tenant-Id") TenantId: String?,
        @Query("grant_type") grant_type: String?,
        @Query("username") username: String?,
        @Query("password") password: String?,
        @Query("scope") scope: String?,
        @Query("tenantid") Tenant_id: String?
    ): BaseResult<String>

    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("user/register")
    suspend fun register(
        @Field("username") username: String,
        @Field("password") pwd: String,
        @Field("repassword") rpwd: String
    ): BaseResult<Any>

    /**
     * 获取banner数据
     */
    @GET("banner/json")
    suspend fun getBanner(): BaseResult<List<BannerBean>>

    /**
     * 获取置顶文章集合数据
     */
    @GET("article/top/json")
    suspend fun getTopAritrilList(): BaseResult<Any>

    /**
     * 获取首页文章数据
     */
    @GET("article/list/{page}/json")
    suspend fun getArticleList(@Path("page") pageNo: Int): BaseResult<HomeBean>

    /**
     * 项目分类标题
     */
    @GET("project/tree/json")
    suspend fun getProjecTitle(): BaseResult<Any>

    /**
     * 根据分类id获取项目数据
     */
    @GET("project/list/{page}/json")
    suspend fun getProjecDataByType(
        @Path("page") pageNo: Int,
        @Query("cid") cid: Int
    ): BaseResult<Any>

    /**
     * 问答
     * pageId,拼接在链接上，例如上面的1
     */
    @GET("wenda/list/{page}/json")
    suspend fun getQuestionList(
        @Path("page") page: Int,
    ): BaseResult<QuestionBean>

    /**
     * 获取最新项目数据
     */
    @GET("article/listproject/{page}/json")
    suspend fun getProjecNewData(@Path("page") pageNo: Int): BaseResult<Any>

    /**
     * 公众号分类
     */
    @GET("wxarticle/chapters/json")
    suspend fun getPublicTitle(): BaseResult<Any>

    /**
     * 获取公众号数据
     */
    @GET("wxarticle/list/{id}/{page}/json")
    suspend fun getPublicData(
        @Path("page") pageNo: Int,
        @Path("id") id: Int
    ): BaseResult<Any>

    /**
     * 获取热门搜索数据
     */
    @GET("hotkey/json")
    suspend fun getSearchData(): BaseResult<Any>

    /**
     * 根据关键词搜索数据
     */
    @POST("article/query/{page}/json")
    suspend fun getSearchDataByKey(
        @Path("page") pageNo: Int,
        @Query("k") searchKey: String
    ): BaseResult<Any>

    /**
     * 广场列表数据
     */
    @GET("user_article/list/{page}/json")
    suspend fun getSquareData(@Path("page") page: Int): BaseResult<Any>

    /**
     * 每日一问列表数据
     */
    @GET("wenda/list/{page}/json")
    suspend fun getAskData(@Path("page") page: Int): BaseResult<Any>

    /**
     * 获取体系数据
     */
    @GET("tree/json")
    suspend fun getSystemData(): BaseResult<Any>

    /**
     * 知识体系下的文章数据
     */
    @GET("article/list/{page}/json")
    suspend fun getSystemChildData(
        @Path("page") pageNo: Int,
        @Query("cid") cid: Int
    ): BaseResult<Any>

    /**
     * 获取导航数据
     */
    @GET("navi/json")
    suspend fun getNavigationData(): BaseResult<Any>

    /**
     * 收藏文章
     */
    @POST("lg/collect/{id}/json")
    suspend fun collect(@Path("id") id: Int): BaseResult<Any>

    /**
     * 取消收藏文章
     */
    @POST("lg/uncollect_originId/{id}/json")
    suspend fun uncollect(@Path("id") id: Int): BaseResult<Any>

    /**
     * 收藏网址
     */
    @POST("lg/collect/addtool/json")
    suspend fun collectUrl(
        @Query("name") name: String,
        @Query("link") link: String
    ): BaseResult<Any>

    /**
     * 取消收藏网址
     */
    @POST("lg/collect/deletetool/json")
    suspend fun deletetool(@Query("id") id: Int): BaseResult<Any>

    /**
     * 获取收藏文章数据
     */
    @GET("lg/collect/list/{page}/json")
    suspend fun getCollectData(@Path("page") pageNo: Int): BaseResult<Any>

    /**
     * 获取收藏网址数据
     */
    @GET("lg/collect/usertools/json")
    suspend fun getCollectUrlData(): BaseResult<Any>

    /**
     * 获取他人分享文章列表数据
     */
    @GET("user/{id}/share_articles/{page}/json")
    suspend fun getShareByidData(
        @Path("id") id: Int,
        @Path("page") page: Int
    ): BaseResult<Any>

    /**
     * 获取当前账户的个人积分
     */
    @GET("lg/coin/userinfo/json")
    suspend fun getIntegral(): BaseResult<Any>

    /**
     * 获取积分排行榜
     */
    @GET("coin/rank/{page}/json")
    suspend fun getIntegralRank(@Path("page") page: Int): BaseResult<Any>

    /**
     * 获取积分历史
     */
    @GET("lg/coin/list/{page}/json")
    suspend fun getIntegralHistory(@Path("page") page: Int): BaseResult<Any>


    /**
     * 获取自己分享的文章列表数据
     */
    @GET("user/lg/private_articles/{page}/json")
    suspend fun getShareData(@Path("page") page: Int): BaseResult<Any>


    /**
     *  删除自己分享的文章
     */
    @POST("lg/user_article/delete/{id}/json")
    suspend fun deleteShareData(@Path("id") id: Int): BaseResult<Any>

    /**
     * 添加文章
     */
    @POST("lg/user_article/add/json")
    @FormUrlEncoded
    suspend fun addAriticle(
        @Field("title") title: String,
        @Field("link") content: String
    ): BaseResult<Any>

    /**
     * 获取Todo列表数据 根据完成时间排序
     */
    @GET("/lg/todo/v2/list/{page}/json")
    suspend fun getTodoData(@Path("page") page: Int): BaseResult<Any>

    /**
     * 添加一个TODO
     */
    @POST("/lg/todo/add/json")
    @FormUrlEncoded
    suspend fun addTodo(
        @Field("title") title: String,
        @Field("content") content: String,
        @Field("date") date: String,
        @Field("type") type: Int,
        @Field("priority") priority: Int
    ): BaseResult<Any>

    /**
     * 修改一个TODO
     */
    @POST("/lg/todo/update/{id}/json")
    @FormUrlEncoded
    suspend fun updateTodo(
        @Field("title") title: String,
        @Field("content") content: String,
        @Field("date") date: String,
        @Field("type") type: Int,
        @Field("priority") priority: Int,
        @Path("id") id: Int
    ): BaseResult<Any>

    /**
     * 删除一个TODO
     */
    @POST("/lg/todo/delete/{id}/json")
    suspend fun deleteTodo(@Path("id") id: Int): BaseResult<Any>

    /**
     * 完成一个TODO
     */
    @POST("/lg/todo/done/{id}/json")
    @FormUrlEncoded
    suspend fun doneTodo(@Path("id") id: Int, @Field("status") status: Int): BaseResult<Any>


}