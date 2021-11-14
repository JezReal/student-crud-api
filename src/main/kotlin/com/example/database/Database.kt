package com.example.database

import com.example.configuration.Configuration
import com.example.tables.Student
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

fun connectToDatabase() {
    val databaseConfiguration = Configuration.getDatabaseConfiguration()

    val hikariConfig = HikariConfig()
    hikariConfig.jdbcUrl = databaseConfiguration.jdbcUrl
    hikariConfig.username = databaseConfiguration.username
    hikariConfig.password = databaseConfiguration.password
    hikariConfig.maximumPoolSize = databaseConfiguration.maxPoolSize

    val dataSource = HikariDataSource(hikariConfig)

    Database.connect(dataSource)

    transaction {
        SchemaUtils.create(Student)
    }

//    prePopulateTables()
}

fun prePopulateTables() {
    transaction {
        Student.insert {
            it[firstName] = "jezreel joshua"
            it[lastName] = "martin"
            it[age] = 21
        }
    }
}