package com.github.jaccek.mrchecker.remote.gitlab.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class GitlabMergeRequest(
    @Json(name = "iid")
    val id: Int,
    val title: String,

    @Json(name = "created_at")
    val creationDate: Date,

    @Json(name = "target_branch")
    val targetBranch: String,
    @Json(name = "source_branch")
    val sourceBranch: String,

    @Json(name = "upvotes")
    val upVotes: Int,
    @Json(name = "downvotes")
    val downVotes: Int,

    @Json(name = "work_in_progress")
    val workInProgress: Boolean
)
