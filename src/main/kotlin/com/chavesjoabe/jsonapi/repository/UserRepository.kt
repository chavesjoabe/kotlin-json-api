package com.chavesjoabe.jsonapi.repository

import com.chavesjoabe.jsonapi.dto.CreateUserDto
import com.chavesjoabe.jsonapi.model.User
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.stereotype.Component
import java.io.File

@Component
class UserRepository() {
    val filePath: String = "data.json";

    fun create(createUserDto: CreateUserDto): User {
        val user = User(
            name = createUserDto.name,
            email = createUserDto.email,
        );

        val objectMapper = jacksonObjectMapper();
        val file: File = File(filePath);

        val userList: MutableList<User> = if (file.exists() || file.length() > 0) {
            objectMapper.readValue(file);
        } else {
            mutableListOf();
        }

        userList.add(user);
        objectMapper.writeValue(file, userList);

        return user
    }

    fun findAll(): List<User> {
        val objectMapper = jacksonObjectMapper();
        val file = File(filePath);

        val userList: MutableList<User> = if (file.exists() || file.length() > 0) {
            objectMapper.readValue(file);
        } else {
            mutableListOf();
        }

        return userList;
    }

    fun findById(id: String): User? {
        val userList = findAll();
        return userList.firstOrNull { user: User -> user.id == id }
    }
}