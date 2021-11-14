package com.example.configuration

class DatabaseConfiguration(
    val jdbcUrl: String,
    val username: String,
    val password: String,
    val maxPoolSize: Int
)