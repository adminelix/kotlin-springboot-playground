package com.github.adminelix.kotlinspringbootplayground

import java.time.Instant

data class ErrorDetails(
    val statusCode: String,
    val timestamp: Instant,
    val message: String,
    val reason: String?,
    val detailMessageCode: String?,
    val detailMessageArguments: Array<Any>?,
    val traceId: String?,
)
