package com.andrecastrosousa.exception

import io.micronaut.http.HttpStatus

class AuthorRequiredException(message: String? = "Author name is required."): QuoteException(message, HttpStatus.BAD_REQUEST) {
}