package com.chavesjoabe.jsonapi.controller

import com.chavesjoabe.jsonapi.dto.CreateUserDto
import com.chavesjoabe.jsonapi.model.User
import com.chavesjoabe.jsonapi.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/user")
class UserController (
    private val userService: UserService,
) {
    @PostMapping("create")
    fun createUser(@RequestBody createUserDto: CreateUserDto) : ResponseEntity<User>{
        val response: User = userService.create(createUserDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("all")
    fun findAll(): ResponseEntity<List<User>> {
        val response = userService.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("id/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<User?> {
        val response = userService.findById(id) ?: return ResponseEntity.noContent().build();

        return ResponseEntity.ok(response);
    }
}