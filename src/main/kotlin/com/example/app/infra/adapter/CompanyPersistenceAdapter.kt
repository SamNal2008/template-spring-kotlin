package com.example.app.infra.adapter

import com.example.app.domain.model.company.Company
import com.example.app.domain.model.company.CompanyNotFound
import com.example.app.domain.port.spi.CompanyPersistencePort
import com.example.app.infra.entities.CompanyEntity
import com.example.app.infra.repository.CompanyRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CompanyPersistenceAdapter(val companyRepository: CompanyRepository) : CompanyPersistencePort {

    override fun save(company: Company) {
        companyRepository.save(CompanyEntity.from(company))
    }

    override fun findById(id: UUID): Company? {
        return companyRepository.findById(id).map { it.toDomain() }.orElseThrow { CompanyNotFound(id) }
    }

    override fun isCompanyNameAlreadyTaken(name: String): Boolean {
        return companyRepository.findByName(name) != null
    }
}