package com.mew.boilerplate.example.services

import com.mew.boilerplate.example.db.entities.Address
import com.mew.boilerplate.example.db.entities.PersonalInfo
import com.mew.boilerplate.example.db.entities.User
import com.mew.boilerplate.example.db.repositories.RoleRepository
import com.mew.boilerplate.example.db.repositories.UserRepository
import com.mew.boilerplate.example.types.dto.response.UserDto
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(val userRepository: UserRepository, val roleRepository: RoleRepository) {
    fun getUsers(): List<User> {
        return userRepository.findAll();
    }

    fun getUserById(id: UUID): User? {
        return userRepository.findById(id).orElse(null);
    }

    fun getUserByName(username: String): User? {
        return userRepository.findByUsername(username);
    }

    fun getUserByMail(email: String): User? {
        return userRepository.findByUsername(email);
    }

    fun createUser(user: User): User {
        val userRoles = user.roles?.mapNotNull { r -> roleRepository.findByName(r.name) }
        user.roles = userRoles?.toList()
        return userRepository.save(user)
    }
}