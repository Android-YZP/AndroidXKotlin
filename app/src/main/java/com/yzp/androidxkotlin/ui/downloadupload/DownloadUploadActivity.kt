package com.yzp.androidxkotlin.ui.downloadupload

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.yzp.androidxkotlin.R
import com.yzp.mvvmlibrary.base.BaseActivity
import com.yzp.mvvmlibrary.base.NoViewModel

class DownloadUploadActivity : BaseActivity<NoViewModel, ViewDataBinding>() {

    override fun layoutId(): Int = R.layout.activity_download_upload

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
    }

}