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
        val textView = holder.getView<View>(R.id.textView) as TextView
        textView.text = item.chapterName
    }


}