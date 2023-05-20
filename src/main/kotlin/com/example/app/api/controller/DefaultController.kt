package com.example.app.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DefaultController {
    @GetMapping("/")
    fun index(): String {
        return "Hello World!"
    }

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello World!"
    }

    @GetMapping("/hello2")
    fun hello2(): String {
        return "Hello World!"
    }
}