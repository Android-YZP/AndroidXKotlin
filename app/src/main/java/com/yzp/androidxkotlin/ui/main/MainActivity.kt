package com.yzp.androidxkotlin.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ToastUtils
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.listener.OnItemLongClickListener
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener
import com.scwang.smart.refresh.layout.listener.OnRefreshListener
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.bean.MainBean
import com.yzp.androidxkotlin.ui.coroutines.CoroutineActivity
import com.yzp.androidxkotlin.ui.home.HomeActivity
import com.yzp.androidxkotlin.ui.updateapk.UpdateActivity
import com.yzp.mvvmlibrary.base.BaseActivity
import com.yzp.mvvmlibrary.base.NoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<NoViewModel, ViewDataBinding>() {
    private var data = ArrayList<MainBean>()

    private val mainAdapter = MainAdapter(data)

    override fun layoutId(): Int = R.layout.activity_main;

    override fun initView(savedInstanceState: Bundle?) {

        with(rv) {
            val linearLayoutManager = LinearLayoutManager(this@MainActivity)
            layoutManager = linearLayoutManager

            mainAdapter.setOnItemClickListener(OnItemClickListener { adapter, view, position ->
                val title = data[position].title
                startActivity(Intent(this@MainActivity, data[position].aClass).apply {
                    putExtra("title", title)
                })
            })

            mainAdapter.setOnItemLongClickListener(OnItemLongClickListener { adapter, view, position ->
                startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                true
            })
            adapter = mainAdapter
        }

        with(refreshLayout) {
            setOnRefreshListener(OnRefreshListener {
                finishRefresh(300)
                log("setOnRefreshListener")
            })
            setOnLoadMoreListener(OnLoadMoreListener {
                finishLoadMore(300)
                log("setOnLoadMoreListener")
            })
        }
    }

    override fun initData() {
        data.add(MainBean("协程", CoroutineActivity::class.java))
        data.add(MainBean("Lifecycle的使用", CoroutineActivity::class.java))
        data.add(MainBean("LiveDataViewModel的使用", CoroutineActivity::class.java))
        data.add(MainBean("Navigation的使用", CoroutineActivity::class.java))
        data.add(MainBean("WorkManager的使用", CoroutineActivity::class.java))
        data.add(MainBean("DataBinding的使用", CoroutineActivity::class.java))
        data.add(MainBean("Room的使用", CoroutineActivity::class.java))
        data.add(MainBean("个人主页框架", CoroutineActivity::class.java))
        data.add(MainBean("列表", CoroutineActivity::class.java))
        data.add(MainBean("网络请求", HomeActivity::class.java))
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

    fun log(s: String) {
        Log.e("===========>", s)
    }


}

