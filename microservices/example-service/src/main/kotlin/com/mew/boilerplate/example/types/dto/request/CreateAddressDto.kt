package com.mew.boilerplate.example.types.dto.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateAddressDto(
    @NotEmpty
    @NotNull
    val street: String,

    @NotEmpty
    @NotNull
    val house: String,

    @NotEmpty
    @NotNull
    val postalCode: String,

    @NotEmpty
    @NotNull
    val city: String,

    @NotEmpty
    @NotNull
    val state: String,

    @NotEmpty
    @NotNull
    val country: String,
)