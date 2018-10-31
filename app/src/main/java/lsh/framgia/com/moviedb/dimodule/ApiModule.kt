package lsh.framgia.com.moviedb.dimodule

import android.content.Context
import lsh.framgia.com.moviedb.BuildConfig
import lsh.framgia.com.moviedb.data.source.remote.network.ApiService
import lsh.framgia.com.moviedb.util.API_END_POINT
import lsh.framgia.com.moviedb.util.NETWORK_TIME_OUT
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module(override = true) {
    single(name = "header") { createHeaderInterceptor() }
    single(name = "logging") { createLoggingInterceptor() }
    single { createOkHttpCache(get()) }
    single { createOkHttpClient(get(), get(name = "header"), get(name = "logging")) }
    single { createRetrofit(get()) }
    single { createApiService(get()) }
}

fun createOkHttpCache(context: Context): Cache {
    val size = (10 * 1024 * 1024).toLong()
    return Cache(context.cacheDir, size)
}

fun createLoggingInterceptor(): Interceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
    else HttpLoggingInterceptor.Level.NONE
    return logging
}

private fun createHeaderInterceptor(): Interceptor {
    return Interceptor { chain ->
        val original = chain.request()
        val newUrl = original.url().newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .build()
        val requestBuilder = original.newBuilder()
            .url(newUrl)
            .build()
        chain.proceed(requestBuilder)
    }
}

fun createOkHttpClient(cache: Cache, header: Interceptor, logging: Interceptor): OkHttpClient {
    val builder = OkHttpClient.Builder()
        .cache(cache)
        .readTimeout(NETWORK_TIME_OUT, TimeUnit.MILLISECONDS)
        .connectTimeout(NETWORK_TIME_OUT, TimeUnit.MILLISECONDS)
        .writeTimeout(NETWORK_TIME_OUT, TimeUnit.MILLISECONDS)
        .addInterceptor(header)
        .addInterceptor(logging)
    return builder.build()
}

fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(API_END_POINT)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun createApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}
