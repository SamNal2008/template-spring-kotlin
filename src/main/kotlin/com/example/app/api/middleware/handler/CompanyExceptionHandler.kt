package com.example.app.api.middleware.handler

import com.example.app.api.controller.CompanyDashboardController
import com.example.app.domain.model.company.CompanyNotFound
import com.example.app.domain.model.company.InvalidCompanyName
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.zalando.problem.Problem
import org.zalando.problem.spring.web.advice.ProblemHandling

@ControllerAdvice(assignableTypes = [CompanyDashboardController::class])
class CompanyExceptionHandler : ProblemHandling {
    @ExceptionHandler(InvalidCompanyName::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBadRequestException(exc: Exception): Nothing {
        CompanyDashboardController.LOGGER.error("Invalid request", exc)
        throw Problem.builder().withTitle("Invalid request").build()
    }

    @ExceptionHandler(CompanyNotFound::class)
    fun handleNotFoundException(exc: Exception): Problem {
        CompanyDashboardController.LOGGER.error("Company not found", exc)
        return Problem.builder()
            .withTitle("Company not found")
            .withDetail(exc.message)
            .withType(Problem.DEFAULT_TYPE.normalize())
            .build()
    }
}