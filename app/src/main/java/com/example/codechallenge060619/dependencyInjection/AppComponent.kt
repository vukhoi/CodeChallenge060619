package com.example.codechallenge060619.dependencyInjection

import com.example.codechallenge060619.view.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ViewModelModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}
