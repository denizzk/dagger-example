package com.dkarakaya.daggerexample.repository

import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface LOTRApiService {

    @GET("book")
    fun fetchBooks(): Observable<Model.Book>

    @GET("movie")
    fun fetchMovies(): Observable<Model.Movie>

    @GET("character")
    fun fetchCharacters(): Observable<Model.Character>

    companion object {
        private const val BASE_URL = "https://the-one-api.herokuapp.com/v1/"
        private const val ACCESS_TOKEN = "Bearer 4dG4pDoMsz0f7c2lB8kF"

        val apiService by lazy {
            create()
        }

        private fun create(): LOTRApiService {
            val okHttpClientBuilder =
                createOkHttpClientBuilder()

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(LOTRApiService::class.java)
        }

        private fun createOkHttpClientBuilder(): OkHttpClient.Builder {
            return OkHttpClient.Builder().addInterceptor { chain ->
                val request = chain.request()
                val newRequest = request.newBuilder().header(
                    "Authorization",
                    ACCESS_TOKEN
                )
                chain.proceed(newRequest.build())
            }
        }
    }

}
