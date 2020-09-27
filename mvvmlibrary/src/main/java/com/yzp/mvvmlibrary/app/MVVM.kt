package com.yzp.mvvmlibrary.app

/**
 */
object MVVM {

    private lateinit var mConfig: GlobalConfig

    fun install(config: GlobalConfig) {
        mConfig = config
    }

    fun getConfig() = mConfig

}