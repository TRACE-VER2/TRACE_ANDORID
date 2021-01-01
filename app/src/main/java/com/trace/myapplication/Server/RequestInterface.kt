package com.trace.myapplication.Server

import com.trace.myapplication.startpage.Server.RequestLogin
import com.trace.myapplication.startpage.Server.ResponseLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface{
    @POST("/api/v1/members/login")
    fun requestLogin(@Body body : RequestLogin) : Call<ResponseLogin>
}