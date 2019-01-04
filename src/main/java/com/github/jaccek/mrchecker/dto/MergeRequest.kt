package com.github.jaccek.mrchecker.dto

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class MergeRequest(
    val author: String = "",
    val project: String = "",
    val pipelineStatus: String = "", // TODO: enum
    val thumbsCount: Int = 0,
    val creationDate: Date = Date(),
    val link: String = ""
)
