package com.example.globalxtremeapp.di.repository

import com.example.globalxtremeapp.Resource
import com.example.globalxtremeapp.model.LoginModel
import com.example.globalxtremeapp.model.LoginResponse
import com.example.globalxtremeapp.network.ApiService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

class AuthRepo(private val apiService: ApiService) : AuthDataSource {
    override fun login(email: String, pass: String): Flowable<Resource<LoginResponse>> {
        val user = LoginModel(email, pass)
        val result = PublishSubject.create<Resource<LoginResponse>>()
        apiService.login(user).subscribeOn(Schedulers.io())
            .observeOn((AndroidSchedulers.mainThread())).take(1).subscribe({ response ->
                result.onNext(Resource.Success(data = response))
            }, {
                result.onNext(Resource.Error(it.message!!))
            })
        return result.toFlowable(BackpressureStrategy.BUFFER)
    }
}


