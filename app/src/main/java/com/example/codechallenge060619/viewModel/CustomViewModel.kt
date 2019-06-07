package com.example.codechallenge060619.viewModel

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.codechallenge060619.network.ImgDetail
import com.example.codechallenge060619.network.ImgGetter
import javax.inject.Inject

class CustomViewModel @Inject constructor(private val imgGetter: ImgGetter): ViewModel() {

    private val imgData = MutableLiveData<List<ImgDetail>>()

    fun getImgData(): MutableLiveData<List<ImgDetail>>{
        imgGetter
            .getAllImg()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                imgData.postValue(it)
            }
        return imgData
    }
}