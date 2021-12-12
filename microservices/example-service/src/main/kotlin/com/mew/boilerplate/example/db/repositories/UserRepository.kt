package com.mew.boilerplate.example.db.repositories

import com.mew.boilerplate.example.db.entities.User
import org.mapstruct.factory.Mappers
import org.springframework.data.domain.Example
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, UUID> {
    fun findByUsername(username: String): User?
    fun findByEmail(email: String): User?
}