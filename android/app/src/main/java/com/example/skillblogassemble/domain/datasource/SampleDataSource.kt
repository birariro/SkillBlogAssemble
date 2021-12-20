package com.example.skillblogassemble.domain.datasource

import com.example.skillblogassemble.domain.model.SampleEntity
import retrofit2.http.GET


/*
임시 API
 */
interface SampleDataSource {
    @GET("v3/a46eef3d-6180-4259-bd54-b3bd65fc62df")
    suspend fun getEntity() : SampleEntity
}