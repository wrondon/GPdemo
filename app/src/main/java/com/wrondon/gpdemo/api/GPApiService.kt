package com.wrondon.gpdemo.api

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GPApiService {

    @GET("api/users")
    fun searchRepos(): LiveData<ApiResponse<UsersListResponse>>

    @GET("api/users")
    fun searchRepos(@Query("page") page: Int): Call<UsersListResponse>



}