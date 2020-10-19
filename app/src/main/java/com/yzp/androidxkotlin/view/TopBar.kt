package com.yzp.androidxkotlin.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import com.blankj.utilcode.util.LogUtils
import com.yzp.androidxkotlin.R

class TopBar : FrameLayout {
    constructor(context: Context) : super(context) {
        initView(context, null)
    }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context, attrs)
    }

    private fun initView(context: Context, attrs: AttributeSet?) {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_top_bar, this, true)
        val mIvBack = view.findViewById<ImageButton>(R.id.iv_back)
        val mTvTitle = view.findViewById<TextView>(R.id.tv_title)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar)
        if (typedArray != null) {
            val title = typedArray.getString(R.styleable.TopBar_title)
            val isBack = typedArray.getBoolean(R.styleable.TopBar_isBack, true)
            if (title != null) {
                mTvTitle.text = title
            }
            if (isBack) {
                mIvBack.visibility = VISIBLE
            } else {
                mIvBack.visibility = GONE
            }
        }
        typedArray.recycle()
    }
}


