package com.yzp.androidxkotlin.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainPagerAdapter(fm: FragmentManager, lists: List<Fragment>) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var mData :List<Fragment> = ArrayList()

    init {
        mData = lists
    }
    override fun getCount(): Int  = mData.size

    override fun getItem(position: Int): Fragment = mData[position]
}