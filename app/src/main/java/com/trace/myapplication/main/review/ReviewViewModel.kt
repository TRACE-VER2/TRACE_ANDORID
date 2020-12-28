package com.trace.myapplication.main.review

import androidx.lifecycle.ViewModel
import com.trace.myapplication.model.Review
import com.trace.myapplication.network.FakeApi

class ReviewViewModel: ViewModel() {
    val fakeApi = FakeApi()
    var thumbnails = listOf<Review>()

    fun getReviews(){
        thumbnails = listOf(
                fakeApi.getReview("jonathan"),
                fakeApi.getReview("jungmin")
        )
    }

    fun getReview(id: String): Review {
        return fakeApi.getReview(id)
    }
}