package com.chavesjoabe.jsonapi.model

import java.util.Date
import java.util.UUID

data class User (
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val email: String,
    val createdAt: String = Date().toString(),
){ }