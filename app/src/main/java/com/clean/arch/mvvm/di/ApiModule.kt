package com.clean.arch.mvvm.di

import com.clean.arch.mvvm.net.MovieApi
import com.clean.arch.mvvm.utils.API_KEY
import com.clean.arch.mvvm.utils.BASE_URL
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

val apiModule = module {

    single { Cache(androidApplication().cacheDir, 10L * 1024 * 1024) }
    single { GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create() }
    single { get<Retrofit>().create(MovieApi::class.java) }

    single {
        OkHttpClient.Builder().cache(get()).apply {
            interceptors().add {
                val request = it.request()
                val url = request.url()
                    .newBuilder()
                    .addQueryParameter("api_key", API_KEY)
                    .addQueryParameter("language", Locale.getDefault().toLanguageTag())
                    .build()
                it.proceed(request.newBuilder().url(url).build())
            }
        }.build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .build()
    }
}