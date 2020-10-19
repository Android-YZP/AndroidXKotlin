package com.yzp.androidxkotlin.wanandroidui.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.adapters.MainPagerAdapter
import com.yzp.mvvmlibrary.base.BaseFragment
import com.yzp.mvvmlibrary.base.NoViewModel
import kotlinx.android.synthetic.main.fragment_square.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView


class MeFragment : BaseFragment<NoViewModel, ViewDataBinding>() {
    private val CHANNELSICON = arrayOf(
        "个人中心",
        "个人知识库"
    )
    private var mData: MutableList<Fragment> = ArrayList()


    override fun layoutId(): Int = R.layout.fragment_me

    override fun initView(savedInstanceState: Bundle?) {
        with(vp_square) {
            mData.add(SystemFragment())//体系
            mData.add(KnowledgeFragment())//广场
            adapter = MainPagerAdapter(childFragmentManager, mData)
            offscreenPageLimit = 2
        }
        initMagicIndicator()
    }

    override fun lazyLoadData() {
        super.lazyLoadData()
    }

    private fun initMagicIndicator() {
        with(mi_square) {
            val commonNavigator = CommonNavigator(context)
            commonNavigator.isAdjustMode = true
            commonNavigator.adapter = object : CommonNavigatorAdapter() {
                override fun getCount(): Int = mData.size

                override fun getTitleView(context: Context?, index: Int): IPagerTitleView {
                    var commonPagerTitleView = CommonPagerTitleView(context)

                    // load custom layout
                    val customLayout: View = LayoutInflater.from(context).inflate(
                        R.layout.item_bottom_bar_layout,
                        null
                    )
                    val titleImg = customLayout.findViewById(R.id.title_img) as ImageView
                    val titleText = customLayout.findViewById(R.id.title_txt) as TextView
                    titleImg.visibility = View.GONE
                    titleText.visibility = View.VISIBLE
                    titleText.text = CHANNELSICON[index]
                    commonPagerTitleView.setContentView(customLayout)

                    commonPagerTitleView.onPagerTitleChangeListener =
                        object : CommonPagerTitleView.OnPagerTitleChangeListener {
                            override fun onSelected(index: Int, totalCount: Int) {
                                titleText.setTextColor(Color.WHITE);
                            }

                            override fun onDeselected(index: Int, totalCount: Int) {
                                titleText.setTextColor(Color.LTGRAY);
                            }

                            override fun onLeave(
                                index: Int,
                                totalCount: Int,
                                leavePercent: Float,
                                leftToRight: Boolean
                            ) {
                                titleText.scaleX = 1.2f + (0.8f - 1.2f) * leavePercent
                                titleText.scaleY = 1.2f + (0.8f - 1.2f) * leavePercent
                            }

                            override fun onEnter(
                                index: Int,
                                totalCount: Int,
                                enterPercent: Float,
                                leftToRight: Boolean
                            ) {
                                titleText.scaleX = 0.8f + (1.2f - 0.8f) * enterPercent
                                titleText.scaleY = 0.8f + (1.2f - 0.8f) * enterPercent
                            }
                        }

                    commonPagerTitleView.setOnClickListener { vp_square.currentItem = index }
                    return commonPagerTitleView
                }

                override fun getIndicator(context: Context?): IPagerIndicator? {
                    return null
                }
            }
            navigator = commonNavigator
            ViewPagerHelper.bind(this, vp_square)
        }
    }
}