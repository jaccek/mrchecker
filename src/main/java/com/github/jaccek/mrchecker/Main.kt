package com.github.jaccek.mrchecker

import com.github.jaccek.mrchecker.dto.MergeRequest
import com.github.jaccek.mrchecker.remote.gitlab.converter.toMergeRequest
import com.github.jaccek.mrchecker.remote.gitlab.dto.GitlabMergeRequest
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.uchuhimo.konf.Config
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import java.util.*

fun main(args: Array<String>) {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
        .build()

    val config = Config { addSpec(GitlabSpec) }
        .from.yaml.file("config.yaml")

    embeddedServer(Netty, 8080) {
        routing {
            get("/") {

                val response = khttp.get(
                    url = config[GitlabSpec.domain] + config[GitlabSpec.apiPath] + "/projects/1438/merge_requests",
//                    params = mapOf("state" to "opened"),
                    headers = mapOf("PRIVATE-TOKEN" to config[GitlabSpec.privateToken])
                )

                val gitlabMrListType = Types.newParameterizedType(List::class.java, GitlabMergeRequest::class.java)
                val gitlabMr = moshi.adapter<List<GitlabMergeRequest>>(gitlabMrListType)
                    .fromJson(response.text)
                val mr = gitlabMr?.map { it.toMergeRequest(config[GitlabSpec.domain]) }

                val mrListType = Types.newParameterizedType(List::class.java, MergeRequest::class.java)
                val body = moshi.adapter<List<MergeRequest>>(mrListType)
                    .toJson(mr)
                call.respondText(body, ContentType.Application.Json)
            }
        }
    }.start(wait = true)
}
