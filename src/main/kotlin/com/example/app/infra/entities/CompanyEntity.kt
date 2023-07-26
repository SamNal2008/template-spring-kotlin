package com.example.app.infra.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "companies")
open class CompanyEntity(
    @Id
    @Column(name = "id", nullable = false)
    val id: UUID,
    @Column(name = "name", nullable = false)
    var name: String
)