package com.example.app.api.mapper

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.zalando.problem.ProblemModule
import org.zalando.problem.validation.ConstraintViolationProblemModule

class ObjectMapper {
    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper().registerModules(ProblemModule(), ConstraintViolationProblemModule())
    }
}