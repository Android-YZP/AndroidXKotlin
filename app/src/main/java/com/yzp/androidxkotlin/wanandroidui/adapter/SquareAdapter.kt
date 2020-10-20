package com.yzp.androidxkotlin.wanandroidui.adapter

import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.bean.DataX
import com.yzp.androidxkotlin.bean.DataY

class SquareAdapter(mData: MutableList<DataY>) : BaseQuickAdapter<DataY, BaseViewHolder>(
    R.layout.layout_item_square, mData
) {
    override fun convert(holder: BaseViewHolder, item: DataY) {
        val tv_author = holder.getView<View>(R.id.tv_author) as TextView
        val tv_title = holder.getView<View>(R.id.tv_title) as TextView
        val tv_label = holder.getView<View>(R.id.tv_label) as TextView
        tv_author.text = item.shareUser
        tv_title.text = item.title
        tv_label.text = item.superChapterName
    }
}