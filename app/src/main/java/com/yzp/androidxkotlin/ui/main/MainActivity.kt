package com.yzp.androidxkotlin.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.listener.OnItemLongClickListener
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener
import com.scwang.smart.refresh.layout.listener.OnRefreshListener
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.ui.home.HomeActivity
import com.yzp.mvvmlibrary.base.BaseActivity
import com.yzp.mvvmlibrary.base.NoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<NoViewModel, ViewDataBinding>() {
    var data = ArrayList<String>()

    val mainAdapter = MainAdapter(data)

    override fun layoutId(): Int = R.layout.activity_main;

    override fun initView(savedInstanceState: Bundle?) {

        with(rv) {
            val linearLayoutManager = LinearLayoutManager(this@MainActivity)
            layoutManager = linearLayoutManager

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
                finishRefresh(3000)
                log("setOnRefreshListener")
            })
            setOnLoadMoreListener(OnLoadMoreListener {
                finishLoadMore(3000)
                log("setOnLoadMoreListener")
            })
        }
    }

    override fun initData() {
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
        data.add("USB")
        data.add("蓝牙")
        data.add("Wifi")
        data.add("串口通信")
        mainAdapter.notifyDataSetChanged()
    }

    fun log(s: String) {
        Log.e("===========>", s)
    }


}