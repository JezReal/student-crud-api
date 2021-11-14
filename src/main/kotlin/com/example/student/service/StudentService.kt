package com.example.student.service

import com.example.student.dto.StudentDto
import com.example.student.dto.StudentWithIdDto
import com.example.student.model.toStudentDto
import com.example.student.model.toStudentWithIdDto
import com.example.student.repository.StudentRepository

object StudentService {

    private val repository = StudentRepository

    fun getStudentList(): List<StudentWithIdDto> {
        return repository.getStudentList().toStudentWithIdDto()
    }

    fun getStudentById(id: Long): StudentDto {
        return repository.getStudentById(id)!!.toStudentDto()
    }

    fun addStudent(studentDto: StudentDto): Long {
        return repository.addStudent(studentDto)
    }

    fun updateStudent(id: Long, studentDto: StudentDto) {
        repository.updateStudent(id, studentDto)
    }

    fun deleteStudent(id: Long) {
        repository.deleteStudent(id)
    }
}