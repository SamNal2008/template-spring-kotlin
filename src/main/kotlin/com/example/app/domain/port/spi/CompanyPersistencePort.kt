package com.example.app.domain.port.spi

import com.example.app.domain.model.company.Company
import com.example.app.domain.model.company.CompanyNotFound
import java.util.*

interface CompanyPersistencePort {
    fun save(company: Company)

    @Throws(CompanyNotFound::class)
    fun findById(id: UUID): Company?

    fun isCompanyNameAlreadyTaken(name: String): Boolean
}