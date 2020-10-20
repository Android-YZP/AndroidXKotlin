package com.yzp.androidxkotlin.base

import cat.ereza.customactivityoncrash.config.CaocConfig
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.tencent.mmkv.MMKV
import com.yzp.androidxkotlin.ui.main.MainActivity
import com.yzp.mvvmlibrary.app.App


class BaseApplication : App() {

    override fun onCreate() {
        super.onCreate()
        //防止项目崩溃，崩溃后打开错误界面
        CaocConfig.Builder.create()
            .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //default: CaocConfig.BACKGROUND_MODE_SHOW_CUSTOM
            .enabled(true)//是否启用CustomActivityOnCrash崩溃拦截机制 必须启用！不然集成这个库干啥？？？
            .showErrorDetails(false) //是否必须显示包含错误详细信息的按钮 default: true
            .showRestartButton(false) //是否必须显示“重新启动应用程序”按钮或“关闭应用程序”按钮default: true
            .logErrorOnRestart(false) //是否必须重新堆栈堆栈跟踪 default: true
            .trackActivities(true) //是否必须跟踪用户访问的活动及其生命周期调用 default: false
            .minTimeBetweenCrashesMs(2000) //应用程序崩溃之间必须经过的时间 default: 3000
            .restartActivity(MainActivity::class.java) // 重启的activity
//            .errorActivity(ErrorActivity::class.java) //发生错误跳转的activity
            .eventListener(null) //允许你指定事件侦听器，以便在库显示错误活动 default: null
            .apply()
         MMKV.initialize(this)

        //Logger的初始化


        //Logger的初始化
        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(true) // 显示线程信息
            .methodCount(1) // 显示这一行的Log又几个方法的嵌套
            .methodOffset(0) // 隐藏内部方法调用，以抵消。默认的5
            .tag("=======》") // 每个日志的全局标记。默认PRETTY_LOGGER
            .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }
}