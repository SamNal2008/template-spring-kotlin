package com.example.app.domain.port.api.company

interface CreateCompanyUseCasePort {
    fun handle(name: String)
}