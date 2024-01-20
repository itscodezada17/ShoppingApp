package com.ujjwal.sneakers.productsList.bindings

import android.annotation.SuppressLint
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ujjwal.sneakers.R

@SuppressLint("CheckResult")
@BindingAdapter("imageUrl")
fun loadImageWithGlide(imageView: AppCompatImageView, imageUrl: String?) {
    if (imageUrl!=null) {
            Glide.with(imageView.context).load(imageUrl)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(imageView)
    }
    else{
        loadImageFromDrawable(imageView, R.drawable.ic_launcher_background)
    }
}

@BindingAdapter("srcDrawable")
fun loadImageFromDrawable(imageView: AppCompatImageView, srcDrawable: Int) {

    Glide.with(imageView.context).load(ContextCompat.getDrawable(imageView.context, srcDrawable))
        .skipMemoryCache(true)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(imageView)
}

fun isSvgUrl(url: String): Boolean {
    return url.contains(".svg")
}
