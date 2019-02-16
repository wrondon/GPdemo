package com.wrondon.gpdemo.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wrondon.gpdemo.vo.GPUser


@Dao
interface GPUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(gpUser: GPUser)

    @Query("SELECT * FROM gpuser")
    fun load(): LiveData<List<GPUser>>

}