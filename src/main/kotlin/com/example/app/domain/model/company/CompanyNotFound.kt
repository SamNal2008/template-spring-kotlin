package com.example.app.domain.model.company

import java.util.*

class CompanyNotFound(companyId: UUID) : RuntimeException() {
    override val message: String = "Company with id $companyId not found"
}