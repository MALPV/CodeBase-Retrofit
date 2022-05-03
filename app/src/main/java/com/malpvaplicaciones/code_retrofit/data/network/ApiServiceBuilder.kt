package com.malpvaplicaciones.code_retrofit.data.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiServiceBuilder {

    //region Service Constants
    private const val BASE_URL = "https://api.brawlstars.com/v1/"

    const val AUTH_HEADER = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LT" +
            "AwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcm" +
            "NlbGw6Z2FtZWFwaSIsImp0aSI6IjVkMDAwNDAxLTBiNWUtNDFlYS04MjFmLWFkNjMxMWU4MDgxMiIsIml" +
            "hdCI6MTY1MTU5NzQ1Mywic3ViIjoiZGV2ZWxvcGVyLzIzYTcyYjJhLTI0ZjctMjM4Ni03ZmQxLTZhNWEz" +
            "NjY1ZDlmNyIsInNjb3BlcyI6WyJicmF3bHN0YXJzIl0sImxpbWl0cyI6W3sidGllciI6ImRldmVsb3Blc" +
            "i9zaWx2ZXIiLCJ0eXBlIjoidGhyb3R0bGluZyJ9LHsiY2lkcnMiOlsiMjAxLjE4OS4xOTUuMjE1Il0sIn" +
            "R5cGUiOiJjbGllbnQifV19.xmVyQdeqif8eU0x8RNhyNSGneC3C51z5UPbMQ4IV3jksn1iYGCXStpETnB" +
            "21E4ByuKk4FWiGKiPk6aJriwiYmA"

    const val GET_BRAWLERS = "brawlers"
    //endregion

    private val interceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()

    operator fun invoke(): ApiServiceClient {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiServiceClient::class.java)
    }
}