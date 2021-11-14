package com.example.exception

class IdNotFoundException(val id: Long) : Exception() {
    override val message: String
        get() = "Id $id not found"
}