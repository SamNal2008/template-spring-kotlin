package com.example.app.domain.model.company

import java.util.*

class CompanyNotFound(companyId: UUID) : Exception() {
    override val message: String = "Company with id $companyId not found"
}