package com.yzp.mvvmlibrary.base

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.TextView
import com.yzp.mvvmlibrary.R

class LoadingDialog(context: Context) : Dialog(context,  R.style.dialog) {
    private var tv_text: TextView? = null

    init {
        /**设置对话框背景透明 */
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.loading)
        tv_text = findViewById<TextView>(R.id.tv_text)
        setCanceledOnTouchOutside(false)
        setMessage("加载中...")
        show()
    }

    /**
     * 为加载进度个对话框设置不同的提示消息
     *
     * @param message 给用户展示的提示信息
     * @return build模式设计，可以链式调用
     */
    fun setMessage(message: String?): LoadingDialog? {
        tv_text!!.text = message
        return this
    }

}