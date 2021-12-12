package com.mew.boilerplate.example.controllers

import com.mew.boilerplate.example.mapping.UserConverter
import com.mew.boilerplate.example.services.UserService
import com.mew.boilerplate.example.types.dto.request.CreateUserDto
import com.mew.boilerplate.example.types.dto.response.UserDto
import org.mapstruct.factory.Mappers
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/users/v1")
@Validated
class UserController(val userService: UserService) {
    val mapper: UserConverter = Mappers.getMapper(UserConverter::class.java)

    @GetMapping
    fun getAllUsers(): Collection<UserDto> {
        return userService.getUsers().map { u -> mapper.toDto(u) }
    }

    @Throws(ResponseStatusException::class)
    @GetMapping("{id}")
    fun getUserById(@PathVariable id: UUID): UserDto {
        val user = userService.getUserById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        return mapper.toDto(user);
    }

    @PostMapping
    fun createUser(@RequestBody dto: CreateUserDto): UserDto {
        val user = mapper.toEntity(dto);
        return mapper.toDto(userService.createUser(user));
    }
}