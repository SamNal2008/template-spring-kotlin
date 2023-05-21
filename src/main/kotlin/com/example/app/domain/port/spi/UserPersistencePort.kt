package com.example.app.domain.port.spi

import com.example.app.domain.model.user.User
import java.util.*

interface UserPersistencePort {
    fun save(user: User)
    fun findById(id: UUID): User?
}