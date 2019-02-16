package com.wrondon.gpdemo.api

import com.google.gson.annotations.SerializedName
import com.wrondon.gpdemo.vo.GPUser


data class UsersListResponse (
    @field:SerializedName("page")
    val page: Int,
    @field:SerializedName("per_page")
    val per_page: Int?,
    @field:SerializedName("total")
    val total: Int?,
    @field:SerializedName("total_pages")
    val total_pages: Int?,
    @field:SerializedName("data")
    val gpUsers: List<GPUser>?
)


