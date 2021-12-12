package com.mew.boilerplate.example.types.dto.request

import com.mew.boilerplate.example.types.UserRole
import com.mew.boilerplate.example.types.dto.response.PersonalInfoDto
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateUserDto(
    @NotEmpty
    @NotNull
    val username: String,

    @NotEmpty
    @NotNull
    @Email
    val email: String,

    @NotEmpty
    @NotNull
    val password: String,
    val roles: Collection<UserRole> = listOf(UserRole.GUEST),

    @NotNull
    val details: CreatePersonalInfoDto
)