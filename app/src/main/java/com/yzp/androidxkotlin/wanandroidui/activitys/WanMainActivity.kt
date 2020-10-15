package com.yzp.androidxkotlin.wanandroidui.activitys

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.adapters.MainPagerAdapter
import com.yzp.androidxkotlin.wanandroidui.fragments.MeFragment
import com.yzp.androidxkotlin.wanandroidui.fragments.QuestionFragment
import com.yzp.androidxkotlin.wanandroidui.fragments.SquareFragment
import com.yzp.androidxkotlin.wanandroidui.fragments.WanHomeFragment
import com.yzp.mvvmlibrary.base.BaseActivity
import com.yzp.mvvmlibrary.base.NoViewModel
import kotlinx.android.synthetic.main.activity_wan_main.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView.OnPagerTitleChangeListener
import java.util.*
import kotlin.collections.ArrayList

class WanMainActivity : BaseActivity<NoViewModel, ViewDataBinding>() {
    private val CHANNELSICON = arrayOf(R.mipmap.ic_bottom_bar_home,
        R.mipmap.ic_bottom_bar_wechat,
        R.mipmap.ic_bottom_bar_navi,
        R.mipmap.ic_bottom_bar_mine)

    private var mData: MutableList<Fragment> = ArrayList()

    override fun layoutId(): Int = R.layout.activity_wan_main

    override fun initView(savedInstanceState: Bundle?) {
        with(vp_main) {
            mData.add(WanHomeFragment())//首页
            mData.add(QuestionFragment())//问答
            mData.add(SquareFragment())//广场
            mData.add(MeFragment())//我的
            adapter = MainPagerAdapter(supportFragmentManager, mData)
        }
        initMagicIndicator()
    }

    override fun initData() {

    }


    private fun initMagicIndicator() {
        with(mi_main) {
            setBackgroundColor(Color.CYAN)
            val commonNavigator = CommonNavigator(this@WanMainActivity)
            commonNavigator.isAdjustMode = true
            commonNavigator.adapter = object : CommonNavigatorAdapter() {
                override fun getCount(): Int = CHANNELSICON.size

                override fun getTitleView(context: Context?, index: Int): IPagerTitleView {
                    var commonPagerTitleView = CommonPagerTitleView(context)

                    // load custom layout
                    val customLayout: View = LayoutInflater.from(context).inflate(
                        R.layout.item_bottom_bar_layout,
                        null
                    )
                    val titleImg = customLayout.findViewById<View>(R.id.title_img) as ImageView
                    titleImg.setImageResource(CHANNELSICON[index])
                    commonPagerTitleView.setContentView(customLayout)

                    commonPagerTitleView.onPagerTitleChangeListener =
                        object : OnPagerTitleChangeListener {
                            override fun onSelected(index: Int, totalCount: Int) {
                                titleImg.setColorFilter(Color.BLUE);
                            }

                            override fun onDeselected(index: Int, totalCount: Int) {
                                titleImg.setColorFilter(Color.LTGRAY);
                            }

                            override fun onLeave(
                                index: Int,
                                totalCount: Int,
                                leavePercent: Float,
                                leftToRight: Boolean
                            ) {
                                titleImg.scaleX = 1.2f + (0.8f - 1.2f) * leavePercent
                                titleImg.scaleY = 1.2f + (0.8f - 1.2f) * leavePercent
                            }

                            override fun onEnter(
                                index: Int,
                                totalCount: Int,
                                enterPercent: Float,
                                leftToRight: Boolean
                            ) {
                                titleImg.scaleX = 0.8f + (1.2f - 0.8f) * enterPercent
                                titleImg.scaleY = 0.8f + (1.2f - 0.8f) * enterPercent
                            }
                        }

                    commonPagerTitleView.setOnClickListener { vp_main.currentItem = index }
                    return commonPagerTitleView
                }

                override fun getIndicator(context: Context?): IPagerIndicator? {
                    return null
                }
            }
            navigator = commonNavigator
            ViewPagerHelper.bind(this, vp_main)
        }
    }
}