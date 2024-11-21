package com.github.adminelix.kotlinspringbootplayground

import mu.KLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.ErrorResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.web.server.ResponseStatusException
import java.time.Instant
import kotlin.reflect.full.findAnnotation

@ControllerAdvice
class GlobalErrorHandler : KLogging() {
    @ExceptionHandler(Throwable::class)
    fun handleGeneralThrowable(
        throwable: Throwable,
        request: WebRequest,
    ): ResponseEntity<*> {
        val status: HttpStatus =
            (throwable as? ErrorResponse)?.let { HttpStatus.valueOf(it.statusCode.value()) }
                ?: throwable::class.findAnnotation<ResponseStatus>()?.code
                ?: HttpStatus.INTERNAL_SERVER_ERROR

        val errorDetails =
            ErrorDetails(
                statusCode = status.name,
                timestamp = Instant.now(),
                message = throwable.message ?: "n/a",
                reason = (throwable as? ResponseStatusException)?.reason,
                detailMessageCode = (throwable as? ResponseStatusException)?.detailMessageCode,
                detailMessageArguments = (throwable as? ResponseStatusException)?.detailMessageArguments,
                traceId = request.getHeader("traceId"),
            )

        logger.error("", throwable)
        return ResponseEntity<Any>(errorDetails, status)
    }
}
