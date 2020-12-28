package com.trace.myapplication.main.review

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.trace.myapplication.R

class PhotoAdapter: RecyclerView.Adapter<PhotoAdapter.PhotoThumbnail>() {
    var photos = listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoThumbnail {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_review_photo, parent,false)
        return PhotoThumbnail(v)
    }

    override fun onBindViewHolder(holder: PhotoThumbnail, position: Int) {
        holder.bind(photos[position])
    }

    override fun getItemCount(): Int = photos.size

    class PhotoThumbnail(view: View): RecyclerView.ViewHolder(view){
        fun bind(source: String){
            val iv = itemView.findViewById<ImageView>(R.id.iv)
            Glide.with(itemView.context)
                    .load(source)
                    .into(iv)
        }
    }
}