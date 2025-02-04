package com.example.globalxtremeapp.di.repository

import com.example.globalxtremeapp.Resource
import com.example.globalxtremeapp.model.LoginResponse
import io.reactivex.rxjava3.core.Flowable

interface AuthDataSource {
    fun login(email: String, pass: String): Flowable<Resource<LoginResponse>>
}