package com.yzp.androidxkotlin.ui.main

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.ActionBar
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.BarUtils
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
import com.yzp.androidxkotlin.ui.lifecycle.LifecycleActivity
import com.yzp.androidxkotlin.ui.livedataviewmodel.LiveDataViewModelActivity
import com.yzp.androidxkotlin.ui.navigation.NavActivity
import com.yzp.androidxkotlin.ui.net.NetActivity
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

    override fun layoutId(): Int = R.layout.activity_main

    @SuppressLint("SetTextI18n")
    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
        Handler().postDelayed(Runnable {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java).apply {
                putExtra("title", title)
            })
            finish()
        }, 1000)
    }


}

