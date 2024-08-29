package com.example.olamap


import okhttp3.HttpUrl
import okhttp3.Interceptor
import  okhttp3.Request
import okhttp3.Response


abstract class AccessTokenInterceptor() : Interceptor {

    private val API_KEY_PARAM = "api_key"
    private val API_KEY_VALUE = "api_key"

    override fun intercept(chain: Interceptor.Chain): Response {

        val originRequest : Request = chain.request()

        val urlwithApiKey : HttpUrl = originRequest.url.newBuilder()
            .addQueryParameter(API_KEY_PARAM,API_KEY_VALUE)
            .build()

        val newRequest : Request = originRequest.newBuilder()
            .url(urlwithApiKey)
            .build()

        return chain.proceed(newRequest)




    }

}