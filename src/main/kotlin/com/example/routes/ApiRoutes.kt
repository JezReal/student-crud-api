package com.example.routes

import com.example.student.studentRoutes
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Routing.apiRoutes() {
    route(API_BASE_URL) {
        get {
            call.respondText("Api routes")
        }
        studentRoutes()
    }
}
//localhost:8080/api/v1
const val API_BASE_URL = "/api/v1"