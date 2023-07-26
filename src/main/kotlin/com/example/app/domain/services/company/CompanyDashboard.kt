package com.example.app.domain.services.company

import com.example.app.domain.command.CreateCompanyCommand
import com.example.app.domain.model.company.Company
import com.example.app.domain.model.company.CompanyNotFound
import com.example.app.domain.model.company.InvalidCompanyName
import com.example.app.domain.port.api.company.CompanyDashboardPort
import com.example.app.domain.port.spi.CompanyPersistencePort
import org.springframework.stereotype.Service
import java.util.*

@Service
class CompanyDashboard(val companyPersistencePort: CompanyPersistencePort) : CompanyDashboardPort {

    fun assertCompanyDoesNotExist(name: String) {
        if (companyPersistencePort.isCompanyNameAlreadyTaken(name)) {
            throw InvalidCompanyName.alreadyTaken(name)
        }
    }

    override fun createCompany(createCompanyCommand: CreateCompanyCommand) {
        assertCompanyDoesNotExist(createCompanyCommand.name)
        Company.create(createCompanyCommand.name).let { companyPersistencePort.save(it) }
    }

    override fun getCompany(companyId: UUID): Company {
        return companyPersistencePort.findById(companyId) ?: throw CompanyNotFound(companyId)
    }

    override fun getCompanies(): List<Company> {
        companyPersistencePort.findAll().let { return it }
    }
}