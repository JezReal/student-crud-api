package com.example.student

import com.example.student.dto.StudentDto
import com.example.student.service.StudentService
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.studentRoutes() {
    val service = StudentService

    get("/students") {
        call.respond(service.getStudentList())
    }

    get("/student/{id}") {
        val id = call.parameters["id"]?.toLong()
        call.respond(service.getStudentById(id!!))
    }

    post("/student") {
        val studentRequest = call.receive<StudentDto>()
        call.respond(service.addStudent(studentRequest))
    }

    put("/student/{id}") {
        val id = call.parameters["id"]?.toLong()
        val studentRequest = call.receive<StudentDto>()

        service.updateStudent(id!!, studentRequest)
        call.respondText("Student updated")
    }

    delete("/student/{id}") {
        val id = call.parameters["id"]?.toLong()

        service.deleteStudent(id!!)
        call.respondText("Student deleted")
    }
}
