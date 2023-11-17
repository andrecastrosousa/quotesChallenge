package com.andrecastrosousa.exception

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import jakarta.inject.Singleton

@Produces
@Singleton
@Requires(classes = [QuoteException::class])
class QuoteExceptionHandler : ExceptionHandler<QuoteException, HttpResponse<Any>> {
    override fun handle(request: HttpRequest<Any>, exception: QuoteException): HttpResponse<Any> {
        return when (exception.status) {
            HttpStatus.NOT_FOUND -> HttpResponse.notFound(exception.message)
            HttpStatus.BAD_REQUEST -> HttpResponse.badRequest(exception.message)
            else -> HttpResponse.status(HttpStatus.BAD_REQUEST, exception.message)
        }
    }
}