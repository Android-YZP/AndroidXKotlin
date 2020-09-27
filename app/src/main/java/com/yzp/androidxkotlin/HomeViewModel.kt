package com.yzp.androidxkotlin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.yzp.androidxkotlin.http.BannerBean
import com.yzp.androidxkotlin.http.BaseResult
import com.yzp.mvvmlibrary.base.BaseViewModel
import com.yzp.mvvmlibrary.http.ExceptionHandle
import com.yzp.mvvmlibrary.http.ResponseThrowable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class HomeViewModel : BaseViewModel() {


    private val homeRepository by lazy {
        HomeRepository.getInstance()
    }

    private val mBanners = MutableLiveData<BaseResult<List<BannerBean>>>()
    private val mLogin = MutableLiveData<BaseResult<String>>()


    fun getBanner(): MutableLiveData<BaseResult<List<BannerBean>>> {
        launchGo({
            mBanners.value = homeRepository.getBannerData()
        }, {
            mBanners.value = null
        })
        return mBanners
    }




    fun login(): MutableLiveData<BaseResult<String>> {
        launchGo({
            mLogin.value = homeRepository.login()

        }, {
            mLogin.value = null
        })
        return mLogin
    }


    fun get2Banner() {
        launchUI {
            launchFlow { homeRepository.login() }
                .flatMapConcat {
                    return@flatMapConcat if (it.code() != 400) {
                        launchFlow {
                            homeRepository.login()
                        }
                    } else throw ResponseThrowable(it.errorCode, it.errorMsg)
                }
                .onStart { defUI.msgEvent.postValue("onStart") }
                .flowOn(Dispatchers.IO)
                .onCompletion { defUI.msgEvent.postValue("onCompletion") }
                .catch {
                    //错误处理
                    val err = ExceptionHandle.handleException(it)
                }
                .collect {
                    Log.e("======", Gson().toJson(it) + "")

                }
        }
    }

}