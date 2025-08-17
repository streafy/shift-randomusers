package com.streafy.shiftrandomusers.core.network

import com.streafy.shiftrandomusers.core.network.models.RemoteResponse
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserApi {
    @GET("/")
    suspend fun getUsers(
        @Query("results") results: Int
    ): RemoteResponse
}

fun RandomUserApi(
    baseUrl: String
): Retrofit {
    return retrofit(baseUrl).create()
}

private fun retrofit(baseUrl: String): Retrofit {
    val jsonConverterFactory = Json.asConverterFactory("application/json".toMediaType())

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(jsonConverterFactory)
        .build()
}