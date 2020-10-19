package com.yzp.androidxkotlin.wanandroidui.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.util.BannerUtils
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.ui.banner.BannerBean

class HomeHeadAdapter(mDatas: List<BannerBean?>?) :
    BannerAdapter<BannerBean?, HomeHeadAdapter.TopLineHolder?>(mDatas) {

    //更新数据
   public fun updateData(data: List<BannerBean?>?) {
        //这里的代码自己发挥，比如如下的写法等等
        mDatas.clear()
        mDatas.addAll(data!!)
        notifyDataSetChanged()
    }


    override fun onCreateHolder(parent: ViewGroup, viewType: Int): TopLineHolder {
        return TopLineHolder(BannerUtils.getView(parent, R.layout.item_home_banner))
    }

    override fun onBindView(
        holder: TopLineHolder?,
        bannerData: BannerBean?,
        position: Int,
        size: Int
    ) {
        holder?.message!!.text = bannerData?.title
        holder?.iv_head!!.load(bannerData?.imagePath)
    }

    inner class TopLineHolder(view: View) : RecyclerView.ViewHolder(view) {
        var message: TextView
        var iv_head: ImageView

        init {
            message = view.findViewById(R.id.tv_message) as TextView
            iv_head = view.findViewById(R.id.iv_head) as ImageView
        }
    }

}
