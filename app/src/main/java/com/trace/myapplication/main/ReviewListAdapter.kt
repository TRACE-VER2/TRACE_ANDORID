package com.trace.myapplication.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trace.myapplication.R
import com.trace.myapplication.model.ReviewThumbnail

class ReviewListAdapter: RecyclerView.Adapter<ReviewListAdapter.ReviewThumbnailViewHolder>() {
    var thumbnails = listOf<ReviewThumbnail>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewThumbnailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_review_thumbnail, parent, false)
        return ReviewThumbnailViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewThumbnailViewHolder, position: Int) {
        holder.bind(thumbnails[position])
    }

    override fun getItemCount(): Int = thumbnails.size

    class ReviewThumbnailViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(thumbnail: ReviewThumbnail){

        }
    }
}