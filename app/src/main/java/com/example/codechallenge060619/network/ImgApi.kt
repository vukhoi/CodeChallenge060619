package com.example.codechallenge060619.network

import io.reactivex.Observable
import retrofit2.http.GET

interface ImgApi {
    @GET("list")
    fun getImageList(): Observable<List<ImgDetail>>
}