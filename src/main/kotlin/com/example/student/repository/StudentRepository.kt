package com.example.student.repository

import com.example.student.dto.StudentDto
import com.example.student.model.StudentModel
import com.example.tables.Student
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import kotlin.concurrent.fixedRateTimer

object StudentRepository {

    fun getStudentList(): List<StudentModel> {
        return transaction {
            Student.selectAll().map {
                StudentModel(
                    it[Student.studentId],
                    it[Student.firstName],
                    it[Student.lastName],
                    it[Student.age]
                )
            }
        }
    }

    fun getStudentById(id: Long): StudentModel? {
        return transaction {
            Student.select { Student.studentId eq id }.firstOrNull()?.let {
                StudentModel(
                    it[Student.studentId],
                    it[Student.firstName],
                    it[Student.lastName],
                    it[Student.age]
                )
            }
        }
    }

    fun addStudent(studentDto: StudentDto): Long {
        return transaction {
            Student.insert {
                it[firstName] = studentDto.firstName
                it[lastName] = studentDto.lastName
                it[age] = studentDto.age
            } get Student.studentId
        }
    }

    fun updateStudent(id: Long, studentDto: StudentDto) {
        transaction {
            Student.update({ Student.studentId eq id }) {
                it[firstName] = studentDto.firstName
                it[lastName] = studentDto.lastName
                it[age] = studentDto.age
            }
        }
    }

    fun deleteStudent(id: Long) {
        transaction {
            Student.deleteWhere { Student.studentId eq id }
        }
    }
}