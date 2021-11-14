package com.example

import com.example.configuration.Configuration
import com.example.database.connectToDatabase
import io.ktor.application.*
import com.example.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    Configuration.setEnvironment(environment)
    connectToDatabase()
    configureRouting()
    configureSerialization()
}
