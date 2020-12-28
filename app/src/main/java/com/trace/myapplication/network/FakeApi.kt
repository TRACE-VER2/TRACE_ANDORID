package com.trace.myapplication.network

import com.trace.myapplication.model.Review

class FakeApi {

    fun getReview(id: String): Review{
        val imgList = listOf(
                "https://i.pinimg.com/originals/0f/a5/b3/0fa5b344954c90b5e3ef5be05a2b2718.jpg",
                "https://images.homify.com/c_fill,f_auto,q_0,w_740/v1568828624/p/photo/image/3202071/11.jpg"
        )
        return Review(
                id,
                7,
                imgList,
                "여기 1년 살았는데 채광이..."
        )
    }
}