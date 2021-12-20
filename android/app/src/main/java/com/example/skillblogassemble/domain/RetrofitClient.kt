package com.example.skillblogassemble.domain

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        private const val BASE_URL = "https://run.mocky.io/"

        fun getInstance(): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}