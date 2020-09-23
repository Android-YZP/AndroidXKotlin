package com.yzp.androidxkotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.listener.OnItemLongClickListener
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener
import com.scwang.smart.refresh.layout.listener.OnRefreshListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //list   携程  主界面框架   个人主页框架
    //        val fromJson = Gson().fromJson("", TestBean::class.java)
//        tv.text = fromJson.data.records[1].pickingUser

    var data = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData() {
        data.add("列表")
        data.add("携程")
        data.add("个人主页框架")
        data.add("主界面框架")

        val linearLayoutManager = LinearLayoutManager(this)
        rv.layoutManager = linearLayoutManager
        val mainAdapter = MainAdapter(data)
        rv.adapter = mainAdapter


        mainAdapter.setOnItemClickListener(OnItemClickListener { adapter, view, position ->
            log(data[position])
        })

        mainAdapter.setOnItemLongClickListener(OnItemLongClickListener { adapter, view, position ->
            log(data[position] + "hahahahaha")
            true
        })

        refreshLayout.setOnRefreshListener(OnRefreshListener {
            it.finishRefresh(3000)
            log("setOnRefreshListener")
        })

        refreshLayout.setOnLoadMoreListener(OnLoadMoreListener {
            it.finishLoadMore(3000)
            log("setOnLoadMoreListener")
        })
    }

    fun log(s: String) {
        Log.e("===========>", s)
    }

}