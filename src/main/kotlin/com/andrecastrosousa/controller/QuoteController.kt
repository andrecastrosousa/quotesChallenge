package com.andrecastrosousa.controller

import com.andrecastrosousa.model.Quote
import com.andrecastrosousa.service.QuoteService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import java.util.concurrent.Flow.Publisher

@Controller("/api/quotes")
class QuoteController(private val quoteService: QuoteService) {

    @Get
    fun listAll(): Publisher<List<Quote>> = quoteService.listAll()

    @Get("/id")
    fun findById(id: String): Publisher<Quote> = quoteService.findById(id)

    @Get("/search")
    fun findByAuthor(@QueryValue author: String?): Publisher<List<Quote>> = quoteService.findByAuthor(author)
}