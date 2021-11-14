package com.example.student

import com.example.response.Response
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
        val generatedId = service.addStudent(studentRequest)
        call.respond(Response("Student with id $generatedId created"))
    }

    put("/student/{id}") {
        val id = call.parameters["id"]?.toLong()
        val studentRequest = call.receive<StudentDto>()

        service.updateStudent(id!!, studentRequest)
        call.respond(Response("Student with id $id updated"))
    }

    delete("/student/{id}") {
        val id = call.parameters["id"]?.toLong()

        service.deleteStudent(id!!)
        call.respond(Response("Student with id $id deleted"))
    }
}
