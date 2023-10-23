package com.jbianchini.currency.controller

import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.web.bind.annotation.ControllerAdvice

@ControllerAdvice
class ControllerHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    fun handleIllegalArgumentException(ex: IllegalArgumentException): ResponseEntity<String> {
        val errorMessage = "Error: ${ex.message}" // Mensaje de error personalizado
        return ResponseEntity.badRequest().body(errorMessage) // Respuesta HTTP 400 con el mensaje de error
    }
}