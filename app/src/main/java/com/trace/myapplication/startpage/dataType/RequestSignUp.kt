package com.trace.myapplication.startpage.dataType

data class RequestSignUp(
        val userId:String,
        val password:String,
        val email:String,
        val name:String,
        val phoneNum: String,
        val preferences: List<String>
)