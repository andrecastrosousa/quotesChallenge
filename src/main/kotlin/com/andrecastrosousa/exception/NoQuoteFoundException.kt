package com.andrecastrosousa.exception

import io.micronaut.http.HttpStatus

class NoQuoteFoundException(message: String? = "No quote found."): QuoteException(message, HttpStatus.NOT_FOUND) {
}