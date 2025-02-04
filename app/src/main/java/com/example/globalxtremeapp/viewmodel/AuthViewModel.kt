package com.example.globalxtremeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import com.example.globalxtremeapp.Resource
import com.example.globalxtremeapp.di.repository.AuthDataSource
import com.example.globalxtremeapp.model.LoginResponse

class AuthViewModel(private val authDataSource: AuthDataSource) : ViewModel(){
    fun login(email: String, pass: String): LiveData<Resource<LoginResponse>> =
        authDataSource.login(email, pass).toLiveData()
}