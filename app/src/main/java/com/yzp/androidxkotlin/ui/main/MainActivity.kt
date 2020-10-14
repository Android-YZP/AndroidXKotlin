package com.yzp.androidxkotlin.ui.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.LogUtils
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.listener.OnItemLongClickListener
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener
import com.scwang.smart.refresh.layout.listener.OnRefreshListener
import com.youth.banner.Banner
import com.youth.banner.transformer.ScaleInTransformer
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.ui.CoroutineActivity
import com.yzp.androidxkotlin.ui.DialogActivity
import com.yzp.androidxkotlin.ui.UpdateActivity
import com.yzp.androidxkotlin.ui.databinding.DataBindingActivity
import com.yzp.androidxkotlin.ui.net.NetActivity
import com.yzp.androidxkotlin.ui.lifecycle.LifecycleActivity
import com.yzp.androidxkotlin.ui.livedataviewmodel.LiveDataViewModelActivity
import com.yzp.androidxkotlin.ui.navigation.NavActivity
import com.yzp.androidxkotlin.ui.workmanager.WorkManagerActivity
import com.yzp.androidxkotlin.wanandroidui.personal.LoginActivity
import com.yzp.mvvmlibrary.base.BaseActivity
import com.yzp.mvvmlibrary.base.NoViewModel
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 接下来要做的就是wanandroidAPP,
 * 估计需要1个月完成,然后整理Android最新知识点,
 * 然后自考.一直到明年年底,完成自考.
 * 到明年年底 changer job
 */
class MainActivity : BaseActivity<NoViewModel, ViewDataBinding>() {
    private var data = ArrayList<MainBean>()

    private val mainAdapter = MainAdapter(data)

    override fun layoutId(): Int = R.layout.activity_main;

    @SuppressLint("SetTextI18n")
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
                startActivity(Intent(this@MainActivity, NetActivity::class.java))
                true
            })
            adapter = mainAdapter
        }

        with(refreshLayout) {
            setOnRefreshListener(OnRefreshListener {
                finishRefresh(300)
                LogUtils.e("setOnRefreshListener")
            })
            setOnLoadMoreListener(OnLoadMoreListener {
                finishLoadMore(300)
                LogUtils.e("setOnLoadMoreListener")
            })
        }

        //添加头布局
        layoutInflater.inflate(R.layout.head_main, null, false).apply {
            val data: MutableList<String> = ArrayList()
            data.add(" 1. 登录注册界面\n 2. 主UI框架\n 3. 轮播图,阅读列表")
            data.add(" 1. 登录注册界面\n 2. 主UI框架\n 3. 轮播图,阅读列表")
            val banner = findViewById<View>(R.id.banner_head) as Banner<*, *>
            with(banner) {
                adapter = MainHeadAdapter(mDatas = data)
                addBannerLifecycleObserver(this@MainActivity)
                setOrientation(Banner.VERTICAL)
                setPageTransformer(ScaleInTransformer())
            }
            mainAdapter.addHeaderView(this)
        }
    }

    override fun initData() {
        data.add(MainBean("协程", CoroutineActivity::class.java))
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
        data.add(MainBean("Wan Android", LoginActivity::class.java))
        mainAdapter.notifyDataSetChanged()
    }

}

