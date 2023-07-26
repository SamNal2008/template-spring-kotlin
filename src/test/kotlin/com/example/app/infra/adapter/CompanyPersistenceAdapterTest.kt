package com.example.app.infra.adapter

import com.example.app.domain.model.company.Company
import com.example.app.infra.entities.CompanyEntity
import com.example.app.infra.repository.CompanyRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.doReturn

@ExtendWith(MockitoExtension::class)
class CompanyPersistenceAdapterTest {

    @Mock
    lateinit var companyRepository: CompanyRepository

    @InjectMocks
    lateinit var companyPersistenceAdapter: CompanyPersistenceAdapter

    @Captor
    lateinit var companyCaptor: ArgumentCaptor<CompanyEntity>

    @Test
    fun shouldSaveCompany() {
        // when
        val companyToSave = Company.create("Company Name")
        doReturn(null).`when`(companyRepository).save(companyCaptor.capture())
        companyPersistenceAdapter.save(companyToSave)

        // then
        assertEquals(companyToSave.id, companyCaptor.value.id)
    }
}