package com.yzp.androidxkotlin.wanandroidui.adapter

import android.text.Html
import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.bean.Datas

class QuestionAdapter(mData: MutableList<Datas>) : BaseQuickAdapter<Datas, BaseViewHolder>(
    R.layout.layout_item_question, mData
) {
    override fun convert(holder: BaseViewHolder, item: Datas) {
        val tv_author = holder.getView<View>(R.id.tv_author) as TextView
        val tv_title = holder.getView<View>(R.id.tv_title) as TextView
        val tv_desc = holder.getView<View>(R.id.tv_desc) as TextView
        tv_author.text = item.chapterName+" | "+item.superChapterName
        tv_title.text = item.title
        tv_desc.text = Html.fromHtml(item.desc).trim()

    }


}