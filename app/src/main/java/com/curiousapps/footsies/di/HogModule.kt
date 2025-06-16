package com.curiousapps.footsies.di

import com.curiousapps.footsies.data.StudentRepositoryImpl
import com.curiousapps.footsies.domain.StudentRepository
import com.curiousapps.footsies.network.HogwartsApi
import com.curiousapps.footsies.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HogModule {

    @Provides
    @Singleton
    fun provideHogwartsApi(): HogwartsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HogwartsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideStudentRepository(
        hogwartsApi: HogwartsApi
    ): StudentRepository = StudentRepositoryImpl(hogwartsApi = hogwartsApi)
}