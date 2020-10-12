package com.yzp.androidxkotlin.ui.main

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.util.BannerUtils
import com.yzp.androidxkotlin.R

class MainHeadAdapter(mDatas: List<String?>?) :
    BannerAdapter<String?, MainHeadAdapter.TopLineHolder?>(mDatas) {


    override fun onCreateHolder(parent: ViewGroup, viewType: Int): TopLineHolder {
        return TopLineHolder(BannerUtils.getView(parent, R.layout.item_banner))
    }

    override fun onBindView(
        holder: TopLineHolder?,
        bannerData: String?,
        position: Int,
        size: Int
    ) {
        holder?.message!!.text = bannerData
    }

    inner class TopLineHolder(view: View) : RecyclerView.ViewHolder(view) {
        var message: TextView

        init {
            message = view.findViewById(R.id.tv_message)
        }
    }

}
