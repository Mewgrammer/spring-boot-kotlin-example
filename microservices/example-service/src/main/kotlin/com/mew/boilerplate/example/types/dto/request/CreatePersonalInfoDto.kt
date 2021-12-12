package com.mew.boilerplate.example.types.dto.request

import com.mew.boilerplate.example.types.dto.response.AddressDto
import java.time.Instant
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreatePersonalInfoDto(
    @NotEmpty
    @NotNull
    val firstName: String,

    @NotEmpty
    @NotNull
    val lastName: String,

    @NotNull
    val birthDate: Instant,
    val address: CreateAddressDto
)