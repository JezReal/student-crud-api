package com.example.plugins

import com.example.exception.IdNotFoundException
import com.example.response.Response
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*

// this is how we configure features in ktor
// create an extension function of the Application class and then
// install the feature that we want and then configure them
// inside the install block

fun Application.configureStatusPages() {
    install(StatusPages) {
        // this is where we will handle all exceptions that we will throw in the application
        // that is related with the request
        // if an exception does not have anything to do with the request, do not include those here

        // if we ever raise an IdNotFoundException, this is what will handle the exception
        exception<IdNotFoundException> { exception ->
            // we can attach a status code to our response by simply setting the first parameter
            // of the respond method to our status code and the second parameter to be the
            // response body which could either be just text or JSON object

            // in this case, we once again used the response object
            call.respond(HttpStatusCode.NotFound, Response(exception.message))
        }
    }
}