package com.github.jaccek.mrchecker.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class MergeRequest(
    val author: String,
    val project: String,
    val title: String,

    @Json(name = "pipeline-status")
    val pipelineStatus: String, // TODO: enum
    @Json(name = "creation-date")
    val creationDate: Date,
    val link: String,

    @Json(name = "up-votes")
    val upVotes: Int,
    @Json(name = "down-votes")
    val downVotes: Int,

    @Json(name = "source-branch")
    val sourceBranch: String,
    @Json(name = "target-branch")
    val targetBranch: String
)
