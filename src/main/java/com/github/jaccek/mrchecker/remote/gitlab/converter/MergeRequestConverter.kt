package com.github.jaccek.mrchecker.remote.gitlab.converter

import com.github.jaccek.mrchecker.dto.MergeRequest
import com.github.jaccek.mrchecker.remote.gitlab.dto.GitlabMergeRequest

// TODO: missing fields
fun GitlabMergeRequest.toMergeRequest() =
    MergeRequest(
        author = author.name,
        creationDate = creationDate,
        link = link,
        project = getProjectName(link),
        pipelineStatus = "TODO",
        upVotes = upVotes,
        downVotes = downVotes,
        title = title,
        sourceBranch = sourceBranch,
        targetBranch = targetBranch
    )

private fun getProjectName(link: String): String {
    val regex = """gitlab\.rst\.com\.pl/(.*)/merge_requests""".toRegex()    // TODO: fix regex - domain from config!!!
    return regex.find(link)?.destructured?.component1() ?: ""
}
