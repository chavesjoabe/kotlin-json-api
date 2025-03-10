package com.chavesjoabe.jsonapi.service

import com.chavesjoabe.jsonapi.dto.CreateUserDto
import com.chavesjoabe.jsonapi.model.User
import com.chavesjoabe.jsonapi.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun create(createUserDto: CreateUserDto): User {
        return userRepository.create(createUserDto);
    }

    fun findAll(): List<User> {
        return userRepository.findAll();
    }

    fun findById(id: String): User? {
        return userRepository.findById(id);
    }
}