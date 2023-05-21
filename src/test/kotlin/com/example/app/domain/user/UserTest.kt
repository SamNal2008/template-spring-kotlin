package com.example.app.domain.user

import com.example.app.domain.model.company.Company
import com.example.app.domain.model.user.User
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class UserTest {

    @Test
    fun shouldHaveOneMoreCompany_whenCreatingACompany() {
        val userId = UUID.randomUUID()
        val user = User(userId, "John", "toto", "toto")
        val initialNumberOfCompanies = user.getCompanies().size

        user.startNewCompany("My Company")

        assertEquals(initialNumberOfCompanies + 1, user.getCompanies().size)
    }

    @Test
    fun shouldHaveOneCompanyLess_whenClosingACompany() {
        val userId = UUID.randomUUID()
        val user = User(userId, "John", "toto", "toto")
        user.startNewCompany("My Company")
        val initialNumberOfCompanies = user.getCompanies().size
        val company = user.getCompanies().first()

        user.closeCompany(company)

        assertEquals(initialNumberOfCompanies - 1, user.getCompanies().size)
    }

    @Test
    fun shouldThrow_WhenClosingCompanyNotOwnedByUser() {
        val randomCompany = Company.create("My Company")
        val userId = UUID.randomUUID()
        val user = User(userId, "John", "toto", "toto")

        assertThrows<Exception> { user.closeCompany(randomCompany) }

    }
}