package com.example.app.infra.entities

import com.example.app.domain.model.company.Company
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "company_entity")
open class CompanyEntity(
    @Id
    @Column(name = "id", nullable = false)
    val id: UUID,
    @Column(name = "name", nullable = false)
    var name: String
) {
    
    fun toDomain(): Company {
        TODO()
    }

    companion object {
        fun from(company: Company): CompanyEntity {
            TODO()
        }
    }
}