package com.example.configuration

import io.ktor.application.*

object Configuration {
    private lateinit var environment: ApplicationEnvironment

    fun setEnvironment(environment: ApplicationEnvironment) {
        this.environment = environment
    }

    fun getDatabaseConfiguration() = DatabaseConfiguration(
        environment.config.propertyOrNull("ktor.database.jdbcUrl")?.getString().toString(),
        environment.config.propertyOrNull("ktor.database.username")?.getString().toString(),
        environment.config.propertyOrNull("ktor.database.password")?.getString().toString(),
        environment.config.propertyOrNull("ktor.database.maxPoolSize")?.getString().toString().toInt()
    )
}