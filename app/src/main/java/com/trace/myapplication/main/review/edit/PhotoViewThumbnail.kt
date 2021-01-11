package com.trace.myapplication.main.review.edit

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.trace.myapplication.R
import com.trace.myapplication.main.review.PhotoThumbnail

class PhotoViewThumbnail(view: View): PhotoThumbnail(view){
    override fun bind(source: String){
        val iv = itemView.findViewById<ImageView>(R.id.iv)
        Glide.with(itemView.context)
                .load(source)
                .into(iv)
    }
}