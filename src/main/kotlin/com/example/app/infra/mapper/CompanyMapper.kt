package com.example.app.infra.mapper

import com.example.app.domain.model.company.Company
import com.example.app.infra.entities.CompanyEntity
import org.mapstruct.Mapper

@Mapper
interface CompanyMapper {
    fun toEntity(company: Company): CompanyEntity
    fun toDomain(entity: CompanyEntity): Company
}