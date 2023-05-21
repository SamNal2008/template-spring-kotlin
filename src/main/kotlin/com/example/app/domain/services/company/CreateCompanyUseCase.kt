package com.example.app.domain.services.company

import com.example.app.domain.model.company.Company
import com.example.app.domain.model.company.InvalidCompanyName
import com.example.app.domain.port.api.company.CreateCompanyUseCasePort
import com.example.app.domain.port.spi.CompanyPersistencePort
import org.springframework.stereotype.Service

@Service
class CreateCompanyUseCase(val companyPersistencePort: CompanyPersistencePort) : CreateCompanyUseCasePort {

    fun assertCompanyDoesNotExist(name: String) {
        if (companyPersistencePort.isCompanyNameAlreadyTaken(name)) {
            throw InvalidCompanyName.alreadyTaken(name)
        }
    }

    override fun handle(name: String) {
        assertCompanyDoesNotExist(name)
        Company.create(name).let { companyPersistencePort.save(it) }
    }
}