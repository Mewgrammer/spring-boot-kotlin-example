package com.mew.boilerplate.example.types.dto.response

import java.time.Instant
import java.util.*

data class PersonalInfoDto(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val birthday: Instant,
    val address: AddressDto
)