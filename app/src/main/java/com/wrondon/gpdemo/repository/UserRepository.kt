/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wrondon.gpdemo.repository



import androidx.lifecycle.LiveData
import com.wrondon.gpdemo.AppExecutors
import com.wrondon.gpdemo.api.GPDemoService
import com.wrondon.gpdemo.db.UserDao
import com.wrondon.gpdemo.testing.OpenForTesting
import com.wrondon.gpdemo.vo.Resource
import com.wrondon.gpdemo.vo.User
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository that handles User objects.
 */
@OpenForTesting
@Singleton
class UserRepository @Inject constructor(
    private val appExecutors: AppExecutors,
    private val userDao: UserDao,
    private val gpDemoService: GPDemoService
) {

    fun loadUser(login: String): LiveData<Resource<User>> {
        return object : NetworkBoundResource<User, User>(appExecutors) {
            override fun saveCallResult(item: User) {
                userDao.insert(item)
            }

            override fun shouldFetch(data: User?) = data == null

            override fun loadFromDb() = userDao.findByLogin(login)

            override fun createCall() = gpDemoService.getUser(login)
        }.asLiveData()
    }
}
