package com.dagger.hilt.data.api

import com.dagger.hilt.data.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers() : Response<List<User>>

}