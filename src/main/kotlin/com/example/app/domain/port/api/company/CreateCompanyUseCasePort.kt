package com.example.app.domain.port.api.company

import com.example.app.domain.command.CreateCompanyCommand
import com.example.app.domain.model.company.Company
import java.util.*

interface CompanyDashboardPort {
    fun createCompany(createCompanyCommand: CreateCompanyCommand)

    fun getCompany(companyId: UUID): Company

    fun getCompanies(): List<Company>
}