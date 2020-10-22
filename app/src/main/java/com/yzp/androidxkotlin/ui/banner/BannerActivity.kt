package com.yzp.androidxkotlin.ui.banner

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load
import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.LogUtils
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.yzp.androidxkotlin.R
import com.yzp.androidxkotlin.ui.main.MainAdapter
import com.yzp.mvvmlibrary.base.BaseActivity
import com.yzp.mvvmlibrary.base.NoViewModel
import kotlinx.android.synthetic.main.activity_banner.*
import kotlinx.android.synthetic.main.fragment_android.*
import kotlinx.android.synthetic.main.fragment_android.rv
import java.io.IOException
import java.io.InputStream


class BannerActivity : BaseActivity<NoViewModel, ViewDataBinding>() {

    override fun layoutId(): Int = R.layout.activity_banner
    private val mData: MutableList<String> by lazy { getAssetPicPath()!! }
    private val mainAdapter by lazy { BannerAdapter(mData) }

    val imageLoader by lazy {
        ImageLoader.Builder(this@BannerActivity)
            .componentRegistry {
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder())
                } else {
                    add(GifDecoder())
                }
            }
            .build()
    }

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
        with(rv) {
            val linearLayoutManager = LinearLayoutManager(this@BannerActivity)
            layoutManager = linearLayoutManager
            adapter = mainAdapter
        }




        mainAdapter.setOnItemClickListener(OnItemClickListener { adapter, view, position ->
            if (mData[position].endsWith(".png")
                || mData[position].endsWith(".jpg")
            ) {  // 根据图片特征找出图片
                image.load( "file:///android_asset/" +mData[position])
            } else {
                image.load(
                    "file:///android_asset/" + mData[position],
                    imageLoader
                )

            }

            image.visibility = View.VISIBLE
        })
        image.setOnClickListener {
            image.visibility = View.GONE
        }
    }


    private fun getAssetPicPath(): MutableList<String>? {
        val am: AssetManager = this.getAssets()
        var path: Array<String>? = null
        try {
            path = am.list("") // ""获取所有,填入目录获取该目录下所有资源
        } catch (e: IOException) {
            e.printStackTrace()
        }
        val pciPaths: MutableList<String> = ArrayList()
        for (i in path!!.indices) {
            if (path[i].endsWith(".png")
                || path[i].endsWith(".jpg")
                || path[i].endsWith(".gif")
            ) {  // 根据图片特征找出图片
                pciPaths.add(path[i])
            }
        }
        return pciPaths
    }
}