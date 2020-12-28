package com.trace.myapplication.main.review

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trace.myapplication.R
import com.trace.myapplication.model.Review

class ReviewListAdapter: RecyclerView.Adapter<ReviewListAdapter.ReviewThumbnailViewHolder>() {
    var thumbnails = listOf<Review>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewThumbnailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_review_thumbnail, parent, false)
        return ReviewThumbnailViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewThumbnailViewHolder, position: Int) {
        holder.bind(thumbnails[position])
    }

    override fun getItemCount(): Int = thumbnails.size

    override fun getItemId(position: Int): Long = thumbnails[position].hashCode().toLong()

    class ReviewThumbnailViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val pAdapter = PhotoAdapter()

        fun bind(review: Review){
            val rv = itemView.findViewById<RecyclerView>(R.id.rv_review_thumbnail_photos)
            rv.adapter = pAdapter
            rv.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            pAdapter.photos = review.photos
            pAdapter.notifyDataSetChanged()

            val tvId = itemView.findViewById<TextView>(R.id.tv_reviewer_id)
            val tvComment = itemView.findViewById<TextView>(R.id.tv_comment)

            tvId.text = review.userId
            tvComment.text = review.comment
        }
    }
}