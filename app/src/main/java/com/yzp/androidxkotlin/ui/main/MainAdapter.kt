package com.yzp.androidxkotlin.ui.main

import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.bean.MainBean

class MainAdapter(mData: MutableList<MainBean>) : BaseQuickAdapter<MainBean, BaseViewHolder>(
    R.layout.layout_item, mData
) {

    override fun convert(holder: BaseViewHolder, item: MainBean) {
        val textView = holder.getView<View>(R.id.textView) as TextView
        textView.text = item.title
    }


}