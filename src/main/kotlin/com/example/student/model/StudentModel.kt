package com.example.student.model

import com.example.student.dto.StudentDto
import com.example.student.dto.StudentWithIdDto

data class StudentModel(
    val studentId: Long,
    val firstName: String,
    val lastName: String,
    val age: Int
)

fun List<StudentModel>.toStudentWithIdDto(): List<StudentWithIdDto> {
    return map {
        StudentWithIdDto(
            it.studentId,
            it.firstName,
            it.lastName,
            it.age
        )
    }
}

fun StudentModel.toStudentDto() = StudentDto(
    this.firstName,
    this.lastName,
    this.age
)
