package com.yzp.androidxkotlin.ui.workmanager

import android.os.Bundle
import android.util.Log
import androidx.databinding.ViewDataBinding
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.yzp.androidxkotlin.R
import com.yzp.mvvmlibrary.base.BaseActivity
import com.yzp.mvvmlibrary.base.NoViewModel

class WorkManagerActivity : BaseActivity<NoViewModel, ViewDataBinding>() {

    override fun layoutId(): Int = R.layout.activity_work_manager

    override fun initView(savedInstanceState: Bundle?) {

        //重复执行
//        PeriodicWorkRequest request = new PeriodicWorkRequest.Builder(MyWorker.class, 15, TimeUnit.SECONDS).build();
//        MyWork myWork = new MyWork();

        //创建约束条件
        val build = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED) //网络链接的时候使用,避免各种网络判断,省时省力
            .build()


        //把 MyWorker 包装成 OneTimeWorkRequest 执行一次
        val request1 = OneTimeWorkRequest.Builder(MyWork::class.java)
            .setConstraints(build)
            .build()

        val request2 = OneTimeWorkRequest.Builder(MyWork::class.java)
            .setConstraints(build)
            .build()

        val request3 = OneTimeWorkRequest.Builder(MyWork::class.java)
            .setConstraints(build)
            .build()


        //链式调用
        WorkManager.getInstance().beginWith(request1).then(request2).then(request3).enqueue()

        //获取状态
        WorkManager.getInstance().getWorkInfoByIdLiveData(request1.id).observe(this, { workInfo ->
            Log.e("------------", workInfo.state.toString() + "")
        })
    }

    override fun initData() {
    }


}