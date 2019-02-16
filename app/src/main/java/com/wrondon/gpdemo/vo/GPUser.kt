package com.wrondon.gpdemo.vo

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(primaryKeys = ["id"])
data class GPUser( @field:SerializedName("id")
                   val id: Int,
                   @field:SerializedName("first_name")
                   val firstName: String?,
                   @field:SerializedName("last_name")
                   val lastName: String?,
                   @field:SerializedName("avatar")
                   val avatar: String?
                   )