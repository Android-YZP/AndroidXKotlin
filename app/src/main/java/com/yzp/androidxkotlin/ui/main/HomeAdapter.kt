package com.yzp.androidxkotlin.ui.main

import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.bean.DataX

class HomeAdapter(mData: MutableList<DataX>) : BaseQuickAdapter<DataX, BaseViewHolder>(
    R.layout.layout_item_home, mData
) {
    override fun convert(holder: BaseViewHolder, item: DataX) {
        val tv_author = holder.getView<View>(R.id.tv_author) as TextView
        val tv_title = holder.getView<View>(R.id.tv_title) as TextView
        val tv_label = holder.getView<View>(R.id.tv_label) as TextView
        tv_author.text = item.chapterName
        tv_title.text = item.title
        tv_label.text = item.superChapterName
    }



}