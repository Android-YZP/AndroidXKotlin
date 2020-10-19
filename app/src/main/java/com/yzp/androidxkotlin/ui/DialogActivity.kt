package com.yzp.androidxkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.lifecycle.lifecycleOwner
import com.blankj.utilcode.util.ToastUtils
import com.yzp.androidxkotlin.R
import kotlinx.android.synthetic.main.activity_dialog.*

class DialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)


        btn1.setOnClickListener {
            MaterialDialog(this).show {
                title(null, "这个是标题")
                message(null, "这是一个普通的对话框")
                debugMode(false)
                cornerRadius(8f)
                positiveButton(null, "不要") {
                    dismiss()
                }
                negativeButton(null, "我要") {
                    ToastUtils.showShort("点击我要")
                    dismiss()
                }
                lifecycleOwner(this@DialogActivity)
            }
        }
    }
}