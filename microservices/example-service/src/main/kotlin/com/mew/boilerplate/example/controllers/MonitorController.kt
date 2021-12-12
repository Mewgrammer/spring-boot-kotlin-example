package com.mew.boilerplate.example.controllers

import com.mew.boilerplate.example.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
class MonitorController {

    @GetMapping("ping")
    fun ping(): Boolean {
        return true;
    }
}