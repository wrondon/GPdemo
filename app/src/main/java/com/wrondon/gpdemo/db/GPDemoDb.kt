package com.wrondon.gpdemo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wrondon.gpdemo.vo.GPUser

@Database(
    entities = [
        GPUser::class
      ],
    version = 1,
    exportSchema = false
)
abstract class GPDemoDb: RoomDatabase() {
    abstract fun gpUserDao(): GPUserDao
}