package com.example.app.domain.model.user

import java.util.*

class UserNotFound(val userId: UUID) : Exception() {
    override val message: String
        get() = "User with id $userId not found"
}