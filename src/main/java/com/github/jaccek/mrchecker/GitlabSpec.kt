package com.github.jaccek.mrchecker

import com.uchuhimo.konf.ConfigSpec

object GitlabSpec : ConfigSpec("gitlab") {
    val domain by required<String>(name = "domain")
    val apiPath by required<String>(name = "api-path")
    val privateToken by required<String>(name = "private-token")
}
