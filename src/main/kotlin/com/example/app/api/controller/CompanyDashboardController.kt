package com.example.app.api.controller

import com.example.app.api.constant.UriList.Companion.COMPANIES_ENDPOINT
import com.example.app.api.constant.UriList.Companion.COMPANY_URI
import com.example.app.api.dto.request.CreateCompanyCommandDto
import com.example.app.api.dto.response.CompaniesDto
import com.example.app.api.dto.response.CompanyDto
import com.example.app.api.mapper.CompanyDtoMapper
import com.example.app.domain.port.api.company.CompanyDashboardPort
import org.mapstruct.factory.Mappers
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping(COMPANIES_ENDPOINT)
class CompanyDashboardController(val companyDashboardPort: CompanyDashboardPort) {

    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(CompanyDashboardController::class.java)
        val COMPANY_MAPPER: CompanyDtoMapper = Mappers.getMapper(CompanyDtoMapper::class.java)
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun getCompanies(): ResponseEntity<CompaniesDto> {
        LOGGER.info("Getting all companies")
        return ResponseEntity.ok(CompaniesDto(companyDashboardPort.getCompanies().map { COMPANY_MAPPER.toDto(it) }))
    }

    @PostMapping
    @ResponseBody
    fun createCompany(@RequestBody createCompanyCommandDto: CreateCompanyCommandDto): ResponseEntity<Void> {
        LOGGER.info("Creating company with name: {}", createCompanyCommandDto.name)
        companyDashboardPort.createCompany(COMPANY_MAPPER.toCreateCompanyCommand(createCompanyCommandDto))
        return ResponseEntity.created(COMPANY_URI).build()
    }

    @GetMapping("/{id}")
    @ResponseBody
    fun getCompany(@PathVariable id: UUID): ResponseEntity<CompanyDto> {
        LOGGER.info("Getting company with id: {}", id)
        val company = companyDashboardPort.getCompany(id)
        return ResponseEntity.ok(COMPANY_MAPPER.toDto(company))
    }
}