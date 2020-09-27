package com.yzp.mvvmlibrary.app

/**
 *   @auther : Aleyn
 *   time   : 2019/11/12
 */
object MVVM {

    private lateinit var mConfig: GlobalConfig

    fun install(config: GlobalConfig) {
        mConfig = config
    }

    fun getConfig() = mConfig

}