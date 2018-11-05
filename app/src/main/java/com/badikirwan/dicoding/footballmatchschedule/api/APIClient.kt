package com.badikirwan.dicoding.footballmatchschedule.api

import com.badikirwan.dicoding.footballmatchschedule.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {

    fun create(): ApiInterface {
        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL + BuildConfig.TSDB_API_KEY + "/")
            .build()
        return retrofit.create(ApiInterface::class.java)
    }
}