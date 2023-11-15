package com.andrecastrosousa.exception

class AuthorRequiredException(message: String? = "Author name is required."): RuntimeException(message) {
}