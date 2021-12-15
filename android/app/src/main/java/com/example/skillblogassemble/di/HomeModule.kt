package com.example.skillblogassemble.di

import com.example.skillblogassemble.domain.RemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object HomeModule {

    @Provides
    fun provideRemoteRepository() : RemoteRepository{
        return RemoteRepository()
    }
}