package com.example.app.domain.model.user

import com.example.app.domain.model.company.Company
import java.util.*

class User(val id: UUID, val name: String, val email: String, val password: String) {

    private var companies: List<Company> = mutableListOf()

    fun startNewCompany(name: String) {
        companies += Company.create(name)
    }

    fun closeCompany(company: Company) {
        if (!companies.contains(company)) throw Exception("Company not owned by user")
        companies -= company
    }

    fun getCompanies(): List<Company> {
        return companies
    }
}