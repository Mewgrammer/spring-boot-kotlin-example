package com.mew.boilerplate.example.mapping

import com.mew.boilerplate.example.db.entities.Role
import com.mew.boilerplate.example.db.entities.User
import com.mew.boilerplate.example.types.dto.response.UserDto
import com.mew.boilerplate.example.types.dto.request.CreateUserDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.NullValueCheckStrategy

@Mapper(uses = [PersonalInfoConverter::class], nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
interface UserConverter {

    @Mapping(target = "email", source = "email")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "details", source = "details")
    fun toEntity(dto: CreateUserDto): User

    @Mapping(target = "email", source = "email")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "details", source = "details")
    @Mapping(target = "roles", source = "roles")
    fun toDto(entity: User): UserDto

    fun rolesToString(roles: Collection<Role>): Collection<String> {
        return roles.map { r -> r.name };
    }

    fun roleToString(role: Role): String {
        return role.name;
    }

}