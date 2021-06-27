package com.hmdrh.daggerhiltmvvm.repository

import com.hmdrh.daggerhiltmvvm.models.GSRegister
import com.hmdrh.daggerhiltmvvm.network.api.MyApis
import retrofit2.Response
import javax.inject.Inject

class MyRepository @Inject  constructor(private val myApis: MyApis) {
    suspend fun Register(UserName: String, Email: String, Password: String): Response<GSRegister> {
        return myApis.Register(UserName, Email, Password)
    }
}