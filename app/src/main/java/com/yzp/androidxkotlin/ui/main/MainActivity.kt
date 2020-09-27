package com.yzp.androidxkotlin.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.listener.OnItemLongClickListener
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener
import com.scwang.smart.refresh.layout.listener.OnRefreshListener
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var data = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData() {
        data.add("携程")
        data.add("个人主页框架")
        data.add("轮播图")
        data.add("列表")
        data.add("WebView")
        data.add("Room的使用")
        data.add("网络请求缓存的使用")
        data.add("Android版本适配")
        data.add("Android权限申请")
        data.add("文件下载/上传")
        data.add("图片选择")
        data.add("音频播放")
        data.add("视频播放")
        data.add("地图")
        data.add("USB/蓝牙/Wifi")
        data.add("串口通信")

        with(rv) {
            val linearLayoutManager = LinearLayoutManager(this@MainActivity)
            layoutManager = linearLayoutManager
            val mainAdapter = MainAdapter(data)
            mainAdapter.setOnItemClickListener(OnItemClickListener { adapter, view, position ->
                log(data[position])
            })

            mainAdapter.setOnItemLongClickListener(OnItemLongClickListener { adapter, view, position ->
                startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                true
            })
            adapter = mainAdapter
        }

        with(refreshLayout) {
            setOnRefreshListener(OnRefreshListener {
                it.finishRefresh(3000)
                log("setOnRefreshListener")
            })
            setOnLoadMoreListener(OnLoadMoreListener {
                it.finishLoadMore(3000)
                log("setOnLoadMoreListener")
            })
        }
    }

    fun log(s: String) {
        Log.e("===========>", s)
    }

}