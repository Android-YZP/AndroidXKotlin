package com.yzp.androidxkotlin.http

import com.yzp.androidxkotlin.base.GlobalConfig.BASE_URL
import com.yzp.mvvmlibrary.http.LoggingInterceptor
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 */
class RetrofitClient {

    companion object {
        fun getInstance() = SingletonHolder.INSTANCE
        private lateinit var retrofit: Retrofit
    }

    private object SingletonHolder {
        val INSTANCE = RetrofitClient()
    }

    init {
        retrofit = Retrofit.Builder()
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    private fun getOkHttpClient(): OkHttpClient {

        return RetrofitUrlManager.getInstance().with(
            OkHttpClient.Builder()
                .connectTimeout(20L, TimeUnit.SECONDS)
                .addNetworkInterceptor(LoggingInterceptor())
                .writeTimeout(20L, TimeUnit.SECONDS)
                .connectionPool(ConnectionPool(8, 15, TimeUnit.SECONDS))
                .connectTimeout(20L, TimeUnit.SECONDS)
        ).build()
    }

    fun <T> create(service: Class<T>?): T =
        retrofit.create(service!!) ?: throw RuntimeException("Api service is null!")
}