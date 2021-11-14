package com.example.student.service

import com.example.exception.IdNotFoundException
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
        //if the repository returned a null value, it means that the id does not exist
        //in which case we will throw an exception which says that the given id does not exist
        return repository.getStudentById(id)?.toStudentDto() ?: throw IdNotFoundException(id)
    }

    fun addStudent(studentDto: StudentDto): Long {
        return repository.addStudent(studentDto)
    }

    fun updateStudent(id: Long, studentDto: StudentDto) {
        // check if a student with the given id exists.
        // if not, throw an exception
        repository.getStudentById(id) ?: throw IdNotFoundException(id)
        repository.updateStudent(id, studentDto)
    }

    fun deleteStudent(id: Long) {
        repository.getStudentById(id) ?: throw IdNotFoundException(id)
        repository.deleteStudent(id)
    }
}