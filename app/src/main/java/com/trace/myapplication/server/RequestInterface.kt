package com.trace.myapplication.server

import com.trace.myapplication.main.dataType.ResponseMainList
import com.trace.myapplication.startpage.dataType.*
import retrofit2.Call
import retrofit2.http.*

interface RequestInterface{
    @POST("/api/v1/members/login")
    fun requestLogin(@Body body : RequestLogin) : Call<ResponseLogin>

    @GET("/api/v1/auth/registered")
    fun ismemberRequest(@Query("name") path: String, @Query("phoneNum") query: String) : Call<ResponseBasic>

    @GET("/api/v1/mail/verification")
    fun kingoRequest(@Query("mail") path: String) : Call<ResponseKingo>

    @GET("/api/v1/auth/registered")
    fun idCheckRequest(@Query("userId") path: String) : Call<ResponseBasic>

    @POST("/api/v1/members/join")
    fun signUpRequest(@Body body : RequestSignUp) : Call<ResponseBasic>

    @GET("/api/v1/buildings")
    fun mainListRequest(@Header("Authorization") header: String) : Call<ResponseMainList>

    @GET("/api/v1/buildings")
    fun listPageRequest(@Header("Authorization") header: String, @Query("location") path: String) : Call<ResponseMainList>


}