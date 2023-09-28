package com.example.movedbtestingapplication.data.di

import com.example.movedbtestingapplication.data.repository.MovieRepositoryImpl
import com.example.movedbtestingapplication.data.service.MovieService
import com.example.movedbtestingapplication.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    private val KEY = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0MTQzOGUxYmNhOTJmNTNiNTI0MzU4NTk5NmIxYmUyMCIsInN1YiI6IjY1MTJlNGJiM2E0YTEyMDBmZjUwYjBhNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.IFS9LrmmNJ97TVcnMIWw-HpygqZkRcREc8Dy2sxfOUU"

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return  Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(Interceptor {
                val request = it.request().newBuilder()
                    .addHeader(
                        "Authorization",
                        KEY
                    )
                    .build()
                it.proceed(request)
            })
            .build()
    }


    @Provides
    @Singleton
    fun provideMovieService(retrofit: Retrofit):MovieService{
        return retrofit.create(MovieService::class.java)
    }

    @Provides
    @Singleton
   fun provideMovieRepository(movieRepositoryImpl: MovieRepositoryImpl):MovieRepository {
       return movieRepositoryImpl
   }

}