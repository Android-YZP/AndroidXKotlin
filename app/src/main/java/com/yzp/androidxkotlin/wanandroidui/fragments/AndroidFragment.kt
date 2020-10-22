package com.yzp.androidxkotlin.wanandroidui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.LogUtils
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.listener.OnItemLongClickListener
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.ui.CoroutineActivity
import com.yzp.androidxkotlin.ui.DialogActivity
import com.yzp.androidxkotlin.ui.UpdateActivity
import com.yzp.androidxkotlin.ui.banner.BannerActivity
import com.yzp.androidxkotlin.ui.databinding.DataBindingActivity
import com.yzp.androidxkotlin.ui.lifecycle.LifecycleActivity
import com.yzp.androidxkotlin.ui.livedataviewmodel.LiveDataViewModelActivity
import com.yzp.androidxkotlin.ui.main.MainAdapter
import com.yzp.androidxkotlin.ui.main.MainBean
import com.yzp.androidxkotlin.ui.navigation.NavActivity
import com.yzp.androidxkotlin.ui.net.NetActivity
import com.yzp.androidxkotlin.ui.workmanager.WorkManagerActivity
import com.yzp.androidxkotlin.wanandroidui.personal.LoginActivity
import com.yzp.mvvmlibrary.base.BaseFragment
import com.yzp.mvvmlibrary.base.NoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_android.*


class AndroidFragment : BaseFragment<NoViewModel, ViewDataBinding>() {
    private var data = ArrayList<MainBean>()

    private val mainAdapter by lazy { MainAdapter(data) }

    override fun layoutId(): Int = R.layout.fragment_android


    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        with(rv) {
            val linearLayoutManager = LinearLayoutManager(activity)
            layoutManager = linearLayoutManager
            adapter = mainAdapter
        }
    }


    override fun lazyLoadData() {
        data.add(MainBean("Wan Android", LoginActivity::class.java))
        data.add(MainBean("协程", CoroutineActivity::class.java))
        data.add(MainBean("RxJava", CoroutineActivity::class.java))
        data.add(MainBean("热修复", BannerActivity::class.java))
        data.add(MainBean("组件化", CoroutineActivity::class.java))
        data.add(MainBean("Lifecycle的使用", LifecycleActivity::class.java))
        data.add(MainBean("LiveDataViewModel的使用", LiveDataViewModelActivity::class.java))
        data.add(MainBean("Navigation的使用", NavActivity::class.java))
        data.add(MainBean("WorkManager的使用", WorkManagerActivity::class.java))
        data.add(MainBean("DataBinding的使用", DataBindingActivity::class.java))
        data.add(MainBean("Room的使用", CoroutineActivity::class.java))
        data.add(MainBean("个人主页框架", CoroutineActivity::class.java))
        data.add(MainBean("列表", CoroutineActivity::class.java))
        data.add(MainBean("网络请求", NetActivity::class.java))
        data.add(MainBean("对话框", DialogActivity::class.java))
        data.add(MainBean("版本更新", UpdateActivity::class.java))
        data.add(MainBean("Android版本适配", CoroutineActivity::class.java))
        data.add(MainBean("Android权限申请", CoroutineActivity::class.java))
        data.add(MainBean("文件下载/上传", CoroutineActivity::class.java))
        data.add(MainBean("图片选择", CoroutineActivity::class.java))
        data.add(MainBean("音频播放", CoroutineActivity::class.java))
        data.add(MainBean("视频播放", CoroutineActivity::class.java))
        data.add(MainBean("地图", CoroutineActivity::class.java))
        data.add(MainBean("WebView", CoroutineActivity::class.java))
        data.add(MainBean("蓝牙", CoroutineActivity::class.java))
        data.add(MainBean("Wifi", CoroutineActivity::class.java))
        data.add(MainBean("串口通信", CoroutineActivity::class.java))
        mainAdapter.notifyDataSetChanged()
    }

    override fun initListener() {
        mainAdapter.setOnItemClickListener(OnItemClickListener { adapter, view, position ->
            val title = data[position].title
            startActivity(Intent(activity, data[position].aClass).apply {
                putExtra("title", title)
            })
        })
    }


}