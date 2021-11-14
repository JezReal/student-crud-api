package com.example.response
//This class holds all generic response messages.
// Instead of returning just a line of text, we will use this to return a JSON object

data class Response(
    val message: String
)
