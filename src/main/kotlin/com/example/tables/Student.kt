package com.example.tables

import org.jetbrains.exposed.sql.Table

object Student : Table("student_table") {
    val studentId = long("student_id").autoIncrement()
    val firstName = varchar("first_name", length = 100)
    val lastName = varchar("last_name", length = 100)
    val age = integer("student_age")

    override val primaryKey: PrimaryKey
        get() = PrimaryKey(studentId)
}