package com.yzp.androidxkotlin.wanandroidui.adapter

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.google.android.flexbox.FlexboxLayout
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.bean.Datas
import com.yzp.androidxkotlin.bean.NaviBean
import com.yzp.androidxkotlin.bean.SystemBean

class NaviAdapter(mData: MutableList<NaviBean>) : BaseQuickAdapter<NaviBean, BaseViewHolder>(
    R.layout.layout_item_system, mData
) {
    override fun convert(holder: BaseViewHolder, item: NaviBean) {
        val tv_title = holder.getView<View>(R.id.tv_title) as TextView
        val fbl_desc = holder.getView<View>(R.id.fbl_system) as FlexboxLayout
        tv_title.text = item.name
        fbl_desc.removeAllViews()
        for (value in item.articles) {
            val textView: TextView =
                LayoutInflater.from(context).inflate(R.layout.item_flb, fbl_desc, false) as TextView
            textView.text = value.title
            fbl_desc.addView(textView)
        }
    }


}