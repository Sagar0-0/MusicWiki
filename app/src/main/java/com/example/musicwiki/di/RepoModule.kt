package com.example.musicwiki.di

import com.example.musicwiki.data.remote.NetworkApi
import com.example.musicwiki.repositories.MainRepository
import com.example.musicwiki.repositories.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideMainRepo(networkApi: NetworkApi) = MainRepositoryImpl(networkApi) as MainRepository
}