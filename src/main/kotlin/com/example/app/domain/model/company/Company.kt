package com.example.app.domain.model.company

import com.example.app.domain.model.employee.Employee
import java.util.*

class Company(val id: UUID, val name: String) {

    private var employees: List<Employee> = mutableListOf()

    fun hireEmployee(employee: Employee) {
        employees += employee
    }

    fun fireEmployee(employee: Employee) {
        employees -= employee
    }

    fun getEmployees(): List<Employee> {
        return employees
    }

    companion object {
        fun create(name: String): Company {
            return Company(UUID.randomUUID(), name)
        }
    }
}