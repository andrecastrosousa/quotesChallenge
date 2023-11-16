package com.andrecastrosousa.service

import com.andrecastrosousa.model.Quote
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface QuoteService {
    fun listAll(): Flux<Quote>
    fun findById(id: String): Mono<Quote>
    fun findByAuthor(author: String?): Flux<Quote>
}