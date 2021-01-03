package com.trace.myapplication.startpage.dataType

data class ResponseBasic(
        val success: Boolean,
        val code: Int,
        val message: String
)