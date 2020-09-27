package com.yzp.androidxkotlin.base

import com.google.gson.annotations.SerializedName
import com.yzp.mvvmlibrary.base.IBaseResponse

data class BaseResult<T>(
    @SerializedName(value = "msg", alternate = ["message", "errorMsg"])
    val errorMsg: String,
    @SerializedName(value = "code", alternate = ["status", "errorCode"])
    val errorCode: Int,
    @SerializedName(value = "data", alternate = ["result", "access_token"])
    val data: T
) : IBaseResponse<T> {

    override fun code() = errorCode

    override fun msg() = errorMsg

    override fun data() = data

    override fun isSuccess() = errorCode == 200


}