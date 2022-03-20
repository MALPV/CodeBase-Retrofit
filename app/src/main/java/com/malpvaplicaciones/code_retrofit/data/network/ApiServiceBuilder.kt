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

    const val AUTH_HEADER = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTM" +
            "xOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJh" +
            "dWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjI5Njk4ZWIzLTVjNjItNDljMi1iMDUwLT" +
            "IxZTdmZDI0N2MyMSIsImlhdCI6MTY0NzczNDQ1Mywic3ViIjoiZGV2ZWxvcGVyLzIzYTcyYjJh" +
            "LTI0ZjctMjM4Ni03ZmQxLTZhNWEzNjY1ZDlmNyIsInNjb3BlcyI6WyJicmF3bHN0YXJzIl0sIm" +
            "xpbWl0cyI6W3sidGllciI6ImRldmVsb3Blci9zaWx2ZXIiLCJ0eXBlIjoidGhyb3R0bGluZyJ9" +
            "LHsiY2lkcnMiOlsiMjAxLjE4OS4yMDguMTc1Il0sInR5cGUiOiJjbGllbnQifV19.UrsQtJrFS" +
            "vDF-1QTHe4Kf_AjSZaX8dJODk1OIrCgFMEMQ0GsN4uuqy1JSoM6llgBkiUeXvIUeofs62sOy9w5Zw"

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