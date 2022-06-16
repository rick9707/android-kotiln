package com.example.android.projectimagepuzzle

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Rect
import java.io.InputStream
import kotlin.math.min

fun sampleBitmapData(destWidth: Int, destHeight: Int, stream: InputStream): Bitmap?
{
    if (destWidth <= 0 || destHeight <= 0)
    {
        return null
    }
    
    return stream.use {
        val option = BitmapFactory.Options().apply { this.inJustDecodeBounds = true }
        BitmapFactory.decodeStream(it, Rect(-1, -1, -1, -1), option)
        val srcWidth = option.outWidth
        val srcHeight = option.outHeight
        val ratio = min(srcWidth / destWidth, srcHeight / destHeight)
    
        it.reset()
        with(option){
            this.inJustDecodeBounds = false
            this.inSampleSize = ratio
        }
        BitmapFactory.decodeStream(it, Rect(-1, -1, -1, -1), option)
    }
}