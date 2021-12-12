package com.mew.boilerplate.example.types.dto.response

import com.mew.boilerplate.example.types.UserRole
import java.util.*

data class UserDto(
    val id: UUID,
    val username: String,
    val email: String,
    val roles: Collection<String>,
    val details: PersonalInfoDto
)