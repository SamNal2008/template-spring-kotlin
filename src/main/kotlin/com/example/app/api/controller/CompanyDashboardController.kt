package com.example.app.api.controller

import com.example.app.api.dto.request.CreateCompanyCommandDto
import com.example.app.domain.port.api.company.CreateCompanyUseCasePort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class CompanyDashboardController(val createCompanyUseCasePort: CreateCompanyUseCasePort) {

    @PostMapping("/companies")
    @ResponseBody
    fun createCompany(@RequestBody createCompanyCommandDto: CreateCompanyCommandDto): ResponseEntity<Void> {
        createCompanyUseCasePort.handle(createCompanyCommandDto.name)
        return ResponseEntity.created(URI.create("")).build()
    }
}