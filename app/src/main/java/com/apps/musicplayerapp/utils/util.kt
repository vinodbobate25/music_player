package com.apps.musicplayerapp.utils

import android.content.Context
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.widget.ImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.bumptech.glide.request.target.BitmapImageViewTarget


fun Context.isConnectedToNetwork(): Boolean {
    val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    return connectivityManager?.activeNetworkInfo?.isConnectedOrConnecting() ?: false
}


fun getRoundedImageTarget(context: Context, imageView: ImageView,
                          radius: Float): BitmapImageViewTarget? {
    return object : BitmapImageViewTarget(imageView) {
        override fun setResource(resource: Bitmap?) {
            val circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.resources, resource)
            circularBitmapDrawable.cornerRadius = radius
            imageView.setImageDrawable(circularBitmapDrawable)
        }
    }
}