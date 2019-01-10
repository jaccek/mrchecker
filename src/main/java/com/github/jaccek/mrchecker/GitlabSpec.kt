package com.github.jaccek.mrchecker

import com.uchuhimo.konf.ConfigSpec

object GitlabSpec : ConfigSpec("gitlab") {
    val baseUrl by required<String>(name = "base-url")
    val privateToken by required<String>(name = "private-token")
}
