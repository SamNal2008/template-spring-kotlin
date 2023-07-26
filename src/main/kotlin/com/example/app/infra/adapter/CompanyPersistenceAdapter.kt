package com.example.app.infra.adapter

import com.example.app.domain.model.company.Company
import com.example.app.domain.model.company.CompanyNotFound
import com.example.app.domain.port.spi.CompanyPersistencePort
import com.example.app.infra.mapper.CompanyMapper
import com.example.app.infra.repository.CompanyRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import java.util.*

@Service
class CompanyPersistenceAdapter(
    val companyRepository: CompanyRepository
) : CompanyPersistencePort {

    companion object {
        val MAPPER: CompanyMapper = Mappers.getMapper(CompanyMapper::class.java)
    }

    override fun save(company: Company) {
        companyRepository.save(MAPPER.toEntity(company))
    }

    override fun findById(id: UUID): Company? {
        return companyRepository.findById(id).map { MAPPER.toDomain(it) }.orElseThrow { CompanyNotFound(id) }
    }

    override fun isCompanyNameAlreadyTaken(name: String): Boolean {
        return companyRepository.findByName(name) != null
    }

    override fun findAll(): List<Company> {
        return companyRepository.findAll().map { MAPPER.toDomain(it) }
    }
}