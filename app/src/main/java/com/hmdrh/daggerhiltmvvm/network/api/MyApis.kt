package com.hmdrh.daggerhiltmvvm.network.api

import com.hmdrh.daggerhiltmvvm.models.GSRegister
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApis {
    @FormUrlEncoded
    @POST("register.php")
    suspend fun Register(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ): Response<GSRegister>

}