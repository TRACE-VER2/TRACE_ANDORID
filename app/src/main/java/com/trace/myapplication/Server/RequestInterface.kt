package com.trace.myapplication.Server

import com.trace.myapplication.main.dataType.ResponseMainList
import com.trace.myapplication.startpage.dataType.RequestLogin
import com.trace.myapplication.startpage.dataType.ResponseLogin
import retrofit2.Call
import retrofit2.http.*

interface RequestInterface{
    @POST("/api/v1/members/login")
    fun requestLogin(@Body body : RequestLogin) : Call<ResponseLogin>

    @GET("/api/v1/buildings")
    fun mainListRequest(@Header("Authorization") header: String) : Call<ResponseMainList>

    @GET("/api/v1/buildings")
    fun listPageRequest(@Header("Authorization") header: String, @Query("location") path: String) : Call<ResponseMainList>


}