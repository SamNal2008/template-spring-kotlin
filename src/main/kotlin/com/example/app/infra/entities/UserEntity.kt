package com.example.app.infra.entities

import com.example.app.domain.model.user.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Getter
import lombok.RequiredArgsConstructor
import lombok.Setter
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.OffsetDateTime
import java.util.*

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "users")
class UserEntity(
    @Id @Column(nullable = false, updatable = false) val id: UUID,
    @Column(nullable = false) val name: String,
    @Column(nullable = false) val email: String,
    @Column(nullable = false) val password: String
) {

    @CreatedDate
    @Column(name = "created_date")
    var createdDate: OffsetDateTime? = null

    @LastModifiedDate
    @Column(name = "last_modified_date")
    var lastModifiedDate: OffsetDateTime? = null

    fun toDomain(): User {
        return User(
            id = id,
            name = name,
            email = email,
            password = password
        )
    }

    companion object {
        fun from(user: User): UserEntity {
            return UserEntity(
                user.id,
                user.name,
                user.email,
                user.password
            )
        }
    }
}