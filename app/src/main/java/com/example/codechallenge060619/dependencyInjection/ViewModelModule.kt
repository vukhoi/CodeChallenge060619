package com.example.codechallenge060619.dependencyInjection

import com.example.codechallenge060619.network.ImgGetter
import com.example.codechallenge060619.viewModel.CustomViewModel

import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ViewModelModule{

    @Provides
    @Singleton
    fun getImageGetter(): ImgGetter{
        return ImgGetter()
    }


    @Provides
    @Singleton
    fun getViewModel(): CustomViewModel{
        return CustomViewModel(getImageGetter())
    }

}