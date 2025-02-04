package com.example.globalxtremeapp.di

import com.example.globalxtremeapp.network.ApiService
import com.example.globalxtremeapp.network.Routing
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single{
        val retrofit = Retrofit.Builder().baseUrl(Routing.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)

    }
}
