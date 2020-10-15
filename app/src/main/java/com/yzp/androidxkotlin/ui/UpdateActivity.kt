package com.yzp.androidxkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.open.hule.library.entity.AppUpdate
import com.open.hule.library.utils.UpdateManager
import com.yzp.androidxkotlin.R
import com.yzp.mvvmlibrary.base.BaseActivity
import com.yzp.mvvmlibrary.base.NoViewModel

class UpdateActivity : BaseActivity<NoViewModel, ViewDataBinding>() {

    override fun layoutId(): Int = R.layout.activity_update

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
        update()
    }


    private fun update() {
        // 更新的数据参数
        val appUpdate = AppUpdate.Builder() //更新地址（必传）
            .newVersionUrl("http://47.114.120.136:9102/apk/2c0dad7983c64358921a7c276a8fad98.apk")
            // 版本号（非必填）
            .newVersionCode("v1.7") // 通过传入资源id来自定义更新对话框，注意取消更新的id要定义为btnUpdateLater，立即更新的id要定义为btnUpdateNow（非必填）
            .updateResourceId(R.layout.dialog_update) // 更新的标题，弹框的标题（非必填，默认为应用更新）
            .updateTitle(R.string.update_title) // 更新内容的提示语，内容的标题（非必填，默认为更新内容）
            .updateContentTitle(R.string.update_content_lb) // 更新内容（非必填，默认“1.用户体验优化\n2.部分问题修复”）
            .updateInfo("1.用户体验优化\n2.部分问题修复") // 文件大小（非必填）
            .fileSize("5.8M") // 保存文件路径（默认前缀：Android/data/包名/files/ 文件名：download）
            .savePath("/A/B") //是否采取静默下载模式（非必填，只显示更新提示，后台下载完自动弹出安装界面），否则，显示下载进度，显示下载失败
            .isSilentMode(false) //是否强制更新（非必填，默认不采取强制更新，否则，不更新无法使用）
            .forceUpdate(0) //文件的MD5值，默认不传，如果不传，不会去验证md5(非静默下载模式生效，若有值，且验证不一致，会启动浏览器去下载)
            .md5("")
            .build()
        UpdateManager().startUpdate(this, appUpdate)
    }
}