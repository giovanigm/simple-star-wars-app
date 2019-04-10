package br.org.venturus.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    fun createApi(): Api {
        return Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .client(createOkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    private fun createOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()

        return builder.build()
    }

}