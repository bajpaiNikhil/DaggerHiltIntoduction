package com.example.daggerhiltintoduction.di

import com.example.daggerhiltintoduction.data.remote.MyApi
import com.example.daggerhiltintoduction.data.repository.MyRepositoryImplementation
import com.example.daggerhiltintoduction.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class) //dependency will live as as the application does
object AppModule {

    private const val BASE_URL =  "https://fakestoreapi.com"

    @Provides
    @Singleton //marks the scope of the dependency. i.e will have the single instance throughOut
    fun provideMyApi(): MyApi {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(loggingInterceptor)
            .build()

        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }


    @Provides
    @Singleton
    fun provideMyRepository(api : MyApi) : MyRepository {
        return MyRepositoryImplementation(api)
    }

}











