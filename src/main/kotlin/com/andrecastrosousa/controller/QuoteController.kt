package com.andrecastrosousa.controller

import com.andrecastrosousa.model.Quote
import com.andrecastrosousa.service.QuoteService
import com.mongodb.lang.Nullable
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.annotation.Error
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Controller("/api/quotes")
class QuoteController(private val quoteService: QuoteService) {

    @Get
    fun listAll(): Flux<Quote> = quoteService.listAll()

    @Get("/{id}")
    @Error(status = HttpStatus.NOT_FOUND)
    fun findById(id: String): Mono<Quote> = quoteService.findById(id)

    @Get("/search")
    @Error(status = HttpStatus.BAD_REQUEST)
    fun findByAuthor(@Nullable @QueryValue author: String?): Flux<Quote> = quoteService.findByAuthor(author)
}