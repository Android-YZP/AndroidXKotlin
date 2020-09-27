package com.yzp.mvvmlibrary.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 */
object ImageAdapter {

    @BindingAdapter(value = ["url", "placeholder"], requireAll = false)
    @JvmStatic
    fun setImageUrl(imageView: ImageView, url: String, placeholder: Int) {
        Glide.with(imageView.context)
            .load(url)
            .apply(RequestOptions().placeholder(placeholder))
            .into(imageView)

    }

}