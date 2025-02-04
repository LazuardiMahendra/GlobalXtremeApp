package com.example.globalxtremeapp.network

import com.example.globalxtremeapp.model.LoginModel
import com.example.globalxtremeapp.model.LoginResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST(Routing.LOGIN_URL)
    fun login(@Body login : LoginModel) : Flowable<LoginResponse>

}