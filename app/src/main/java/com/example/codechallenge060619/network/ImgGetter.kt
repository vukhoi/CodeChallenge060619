package com.example.codechallenge060619.network

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ImgGetter @Inject constructor(){
    private lateinit var imgApi: ImgApi

    init {
        initializeRetrofit()
    }


    private fun initializeRetrofit() {
        imgApi = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://picsum.photos/")
            .build()
            .create(ImgApi::class.java)
    }


    fun getAllImg(): Observable<List<ImgDetail>>{
        return imgApi.getImageList()
    }


}