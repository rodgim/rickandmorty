package com.rodgim.rickandmorty.data.remote

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer

const val TAG = "LoggingInterceptor"

class LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val body = request.body
        val requestBody = if (body != null) {
            val buffer = Buffer()
            body.writeTo(buffer)
            buffer.readUtf8()
        } else {
            "null"
        }

        val requestLog = String.format(
            "Sending request %s %s on %s%n%s%s",
            request.method, request.url, chain.connection(),
            request.headers, "Body: $requestBody"
        )

        val response = chain.proceed(request)
        val bodyString = response.body?.string()

        Log.d( TAG, "Request\n$requestLog")
        Log.d( TAG, "Response(${request.method} ${response.code})\n$bodyString")

        return response.newBuilder()
            .body(bodyString!!.toResponseBody(response.body?.contentType()))
            .build()
    }
}