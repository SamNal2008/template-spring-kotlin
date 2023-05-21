package com.example.app.infra.adapter

import com.example.app.domain.model.user.User
import com.example.app.domain.model.user.UserNotFound
import com.example.app.domain.port.spi.UserPersistencePort
import com.example.app.infra.entities.UserEntity
import com.example.app.infra.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserPersistenceAdapter(val userRepository: UserRepository) : UserPersistencePort {
    override fun save(user: User) {
        userRepository.save(UserEntity.from(user))
    }

    override fun findById(id: UUID): User? {
        return userRepository.findById(id).map { it.toDomain() }.orElseThrow { UserNotFound(id) }
    }
}