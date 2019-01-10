package com.github.jaccek.mrchecker.remote.gitlab.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GitlabUser (
    val name: String,
    val username: String,

    @Json(name = "avatar_url")
    val avatarUrl: String
)
