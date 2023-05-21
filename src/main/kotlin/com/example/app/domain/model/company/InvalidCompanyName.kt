package com.example.app.domain.model.company

class InvalidCompanyName(private val errorMessage: String) : Exception() {
    override val message: String
        get() = errorMessage

    companion object {
        fun alreadyTaken(name: String): InvalidCompanyName {
            val errorMessage = "Company name: '$name' is already taken"
            return InvalidCompanyName(errorMessage)
        }

        fun tooShort(name: String): InvalidCompanyName {
            val errorMessage = "Company name: '$name' is too short"
            return InvalidCompanyName(errorMessage)
        }
    }
}