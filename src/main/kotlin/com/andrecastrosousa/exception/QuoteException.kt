package com.andrecastrosousa.exception

import io.micronaut.http.HttpStatus

open class QuoteException(message: String? = "Quote exception", val status: HttpStatus) : RuntimeException(message)