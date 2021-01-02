package com.trace.myapplication.startpage.dataType

data class ResponseLogin(
        val code : Int,
        val success : Boolean,
        val msg : String,
        val data : SomeData?
)

data class SomeData(
        val accessToken : String,
        val refreshToken : String
)