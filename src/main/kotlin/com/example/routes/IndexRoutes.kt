package com.example.routes

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Routing.indexRoutes() {
    get {
        call.respondText("Index route")
    }
}

//localhost:8080