package com.trace.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repository {
    val retrofitJagguTrace = Retrofit.Builder()
            .baseUrl("http://jaggutrace.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

//    val retrofitReview = Retrofit.Builder()
//            .baseUrl("https://api.cakes.com/api/v1/reviews")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()

    var service: MainApiInterface = retrofitJagguTrace.create(
            MainApiInterface::class.java)
}