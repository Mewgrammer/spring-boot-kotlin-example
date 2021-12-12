package com.mew.boilerplate.example.types.dto.response

import java.util.*

data class AddressDto(
    val id: UUID,
    val street: String,
    val house: String,
    val postalCode: String,
    val city: String,
    val state: String,
    val country: String,
)