package com.rodgim.rickandmorty.di

import com.rodgim.rickandmorty.BuildConfig
import com.rodgim.rickandmorty.data.datasources.CharacterDataSource
import com.rodgim.rickandmorty.data.remote.LoggingInterceptor
import com.rodgim.rickandmorty.data.remote.RetrofitCharacterDataSource
import com.rodgim.rickandmorty.data.remote.RickAndMortyApi
import com.rodgim.rickandmorty.data.repositories.MainCharacterRepository
import com.rodgim.rickandmorty.domain.repositories.CharacterRepository
import com.rodgim.rickandmorty.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: LoggingInterceptor
    ) : OkHttpClient {
        val client = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            client.addInterceptor(loggingInterceptor)
        }

        return client.build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor() = LoggingInterceptor()

    @Singleton
    @Provides
    fun providerApi(
        retrofit: Retrofit
    ): RickAndMortyApi = retrofit.create(RickAndMortyApi::class.java)

    @Singleton
    @Provides
    fun provideCharacterRepository(
        characterDataSource: CharacterDataSource
    ): CharacterRepository = MainCharacterRepository(characterDataSource)

    @Singleton
    @Provides
    fun provideCharacterDataSource(
        api: RickAndMortyApi
    ): CharacterDataSource = RetrofitCharacterDataSource(api)
}