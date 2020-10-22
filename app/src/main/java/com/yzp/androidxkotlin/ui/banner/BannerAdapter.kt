package com.yzp.androidxkotlin.ui.banner

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.yzp.androidxkotlin.R
import java.io.IOException
import java.io.InputStream

class BannerAdapter(mData: MutableList<String>) : BaseQuickAdapter<String, BaseViewHolder>(
    R.layout.layout_item_banner, mData
) {
    private val imageLoader by lazy {
        ImageLoader.Builder(context.applicationContext)
            .componentRegistry {
                if (Build.VERSION.SDK_INT >= 28) {
                    add(ImageDecoderDecoder())
                } else {
                    add(GifDecoder())
                }
            }
            .build()
    }

    override fun convert(holder: BaseViewHolder, item: String) {
        val textView = holder.getView<View>(R.id.image) as ImageView
        textView.load("file:///android_asset/$item", imageLoader)

    }

}