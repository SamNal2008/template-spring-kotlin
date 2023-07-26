package com.example.app.api.middleware.handler

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.zalando.problem.Problem
import org.zalando.problem.spring.web.advice.ProblemHandling

@ControllerAdvice
class GlobalExceptionHandler : ProblemHandling {

    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(exc: Exception): Problem {
        LOGGER.error("Internal server error", exc)
        throw Problem.builder().withTitle("Internal server error").build()
    }
}