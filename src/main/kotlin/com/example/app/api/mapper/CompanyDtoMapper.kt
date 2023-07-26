package com.example.app.api.mapper

import com.example.app.api.dto.request.CreateCompanyCommandDto
import com.example.app.api.dto.response.CompanyDto
import com.example.app.domain.command.CreateCompanyCommand
import com.example.app.domain.model.company.Company
import org.mapstruct.Mapper

@Mapper
interface CompanyDtoMapper {
    fun toDto(company: Company): CompanyDto
    fun toDomain(dto: CompanyDto): Company
    fun toDtoList(companies: List<Company>): List<CompanyDto>
    fun toCreateCompanyCommand(createCompanyCommandDto: CreateCompanyCommandDto): CreateCompanyCommand
}