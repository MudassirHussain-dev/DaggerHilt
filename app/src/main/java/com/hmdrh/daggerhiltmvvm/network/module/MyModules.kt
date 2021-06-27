package com.hmdrh.daggerhiltmvvm.network.module

import com.hmdrh.daggerhiltmvvm.network.api.MyApis
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MyModules {
    @Provides
    fun providesBaseUrl(): String = "http://192.168.2.39/UserApi/"

    @Provides
    @Singleton
    fun providesRetrofitInstance(BASE_URL: String): MyApis =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApis::class.java)
}