package com.yzp.androidxkotlin.ui.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWork(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {

    override fun doWork(): Result {
        compress()
        return Result.success()
    }

    /**
     * 压缩图片任务
     */
    private fun compress() {
        Log.e("-----", "compress: 对图片进行压缩")
    }

}