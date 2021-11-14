package com.example.student.dto

import com.google.gson.annotations.SerializedName

data class StudentDto(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("age")
    val age: Int
)
