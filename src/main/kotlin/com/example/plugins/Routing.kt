package com.example.plugins

import com.example.routes.apiRoutes
import com.example.routes.indexRoutes
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.features.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {

    routing {
        indexRoutes()
        apiRoutes()
    }
}

