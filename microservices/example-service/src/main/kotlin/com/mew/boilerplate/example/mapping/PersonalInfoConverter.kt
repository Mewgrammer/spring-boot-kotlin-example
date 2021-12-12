package com.mew.boilerplate.example.mapping

import com.mew.boilerplate.example.db.entities.PersonalInfo
import com.mew.boilerplate.example.types.dto.request.CreatePersonalInfoDto
import com.mew.boilerplate.example.types.dto.response.PersonalInfoDto
import org.mapstruct.Mapper

@Mapper(uses = [AddressConverter::class])
interface PersonalInfoConverter {
    fun toEntity(dto: CreatePersonalInfoDto): PersonalInfo;
    fun toDto(entity: PersonalInfo): PersonalInfoDto;
}