package com.example.app.infra.repository

import com.example.app.infra.entities.CompanyEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CompanyRepository : JpaRepository<CompanyEntity, UUID> {
    fun findByName(name: String): CompanyEntity?
}