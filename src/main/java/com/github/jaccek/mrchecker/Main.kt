package com.github.jaccek.mrchecker

import com.github.jaccek.mrchecker.dto.MergeRequest
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.util.*

fun main(args: Array<String>) {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
        .build()

    embeddedServer(Netty, 8080) {
        routing {
            get("/") {
                val body = moshi.adapter<MergeRequest>(MergeRequest::class.java).toJson(MergeRequest())
                call.respondText(body, ContentType.Application.Json)
            }
        }
    }.start(wait = true)
}
