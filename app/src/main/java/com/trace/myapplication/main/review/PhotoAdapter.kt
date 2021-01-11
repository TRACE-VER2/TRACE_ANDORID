package com.trace.myapplication.main.review

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.trace.myapplication.R
import com.trace.myapplication.main.review.edit.PhotoUploadThumbnail
import com.trace.myapplication.main.review.edit.PhotoViewThumbnail

class PhotoAdapter: RecyclerView.Adapter<PhotoThumbnail>() {
    var photos = listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewThumbnail {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_review_photo, parent,false)
        return PhotoViewThumbnail(v)
    }

    override fun onBindViewHolder(holder: PhotoThumbnail, position: Int) {
        holder.bind(photos[position])
    }

    override fun getItemCount(): Int = photos.size
}