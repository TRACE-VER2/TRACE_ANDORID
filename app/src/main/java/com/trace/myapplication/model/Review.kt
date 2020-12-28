package com.trace.myapplication.model

data class Review(
    val userId: String,
    val score: Int,
    val photos: List<String>,
    val comment: String
)