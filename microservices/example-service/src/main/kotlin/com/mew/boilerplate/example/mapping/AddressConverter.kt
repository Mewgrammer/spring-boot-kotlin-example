package com.mew.boilerplate.example.mapping

import com.mew.boilerplate.example.db.entities.Address
import com.mew.boilerplate.example.types.dto.response.AddressDto
import com.mew.boilerplate.example.types.dto.request.CreateAddressDto
import org.mapstruct.Mapper

@Mapper
interface AddressConverter {
    fun toEntity(dto: CreateAddressDto): Address;
    fun toDto(entity: Address): AddressDto;
}