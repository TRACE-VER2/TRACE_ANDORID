package com.trace.myapplication.main.review

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class PhotoThumbnail(view: View): RecyclerView.ViewHolder(view) {
    abstract fun bind(source: String)
}