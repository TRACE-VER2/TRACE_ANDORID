package com.trace.myapplication.startpage.dataType

data class ResponseKingo(
        val success: Boolean,
        val code: Int,
        val msg: String,
        val data: KingoData?
)
data class KingoData(
        val verificationKey: String
)