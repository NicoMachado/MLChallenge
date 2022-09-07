package com.cse.mlchallenge.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter( "android:loadImage")
fun loadImage(imageView: ImageView, url: String?){
    Glide.with(imageView.context).load(url).centerCrop().into(imageView)
}