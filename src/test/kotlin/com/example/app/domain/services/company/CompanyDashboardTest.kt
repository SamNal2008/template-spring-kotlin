package com.example.app.domain.services.company

import com.example.app.domain.command.CreateCompanyCommand
import com.example.app.domain.model.company.InvalidCompanyName
import com.example.app.domain.port.spi.CompanyPersistencePort
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any

@ExtendWith(MockitoExtension::class)
class CompanyDashboardTest {

    @InjectMocks
    lateinit var companyDashboard: CompanyDashboard

    @Mock
    lateinit var companyPersistencePort: CompanyPersistencePort

    companion object {
        const val COMPANY_NAME = "Company Name"
    }

    @Test
    fun shouldCreateCompany() {
        // GIVEN
        doReturn(false).`when`(companyPersistencePort).isCompanyNameAlreadyTaken(COMPANY_NAME)
        // WHEN
        companyDashboard.createCompany(CreateCompanyCommand(COMPANY_NAME))
        // THEN
        verify(companyPersistencePort).save(any())
    }

    @Test
    fun shouldThrowIfCompanyNameAlreadyExists() {
        // GIVEN
        doReturn(true).`when`(companyPersistencePort).isCompanyNameAlreadyTaken(COMPANY_NAME)
        // WHEN
        val exception = assertThrows(InvalidCompanyName::class.java) {
            companyDashboard.createCompany(CreateCompanyCommand(COMPANY_NAME))
        }
        // THEN
        assertEquals("Company name: '${COMPANY_NAME}' is already taken", exception.message)
    }
}