package com.github.jaccek.mrchecker.remote.gitlab.converter

import com.github.jaccek.mrchecker.dto.MergeRequest
import com.github.jaccek.mrchecker.remote.gitlab.dto.GitlabMergeRequest

fun GitlabMergeRequest.toMergeRequest() =
    MergeRequest(
        author = "TODO",        // TODO: missing fields
        creationDate = creationDate,
        link = "TODO",
        project = "TODO",
        pipelineStatus = "TODO",
        upVotes = upVotes,
        downVotes = downVotes,
        title = title,
        sourceBranch = sourceBranch,
        targetBranch = targetBranch
    )
