package com.yzp.androidxkotlin.wanandroidui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.adapters.MainPagerAdapter
import com.yzp.mvvmlibrary.base.BaseFragment
import com.yzp.mvvmlibrary.base.NoViewModel
import kotlinx.android.synthetic.main.activity_wan_main.*

class SquareFragment : BaseFragment<NoViewModel, ViewDataBinding>() {
    private val CHANNELSICON = arrayOf(R.mipmap.ic_bottom_bar_home,
        R.mipmap.ic_bottom_bar_wechat,
        R.mipmap.ic_bottom_bar_navi,
        R.mipmap.ic_bottom_bar_mine)
    private var mData: MutableList<Fragment> = ArrayList()

    override fun layoutId(): Int = R.layout.fragment_square

    override fun initView(savedInstanceState: Bundle?) {
        with(vp_main) {
            mData.add(WanHomeFragment())//首页
            mData.add(QuestionFragment())//问答
            mData.add(SquareFragment())//广场
            mData.add(MeFragment())//我的
            adapter = MainPagerAdapter(activity!!.supportFragmentManager, mData)
        }
    }

    override fun lazyLoadData() {

    }


}

