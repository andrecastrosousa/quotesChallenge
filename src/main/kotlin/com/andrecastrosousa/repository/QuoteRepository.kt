package com.andrecastrosousa.repository

import com.andrecastrosousa.model.Quote
import jakarta.validation.Valid
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface QuoteRepository {
    fun findAll(): Flux<Quote>
    fun findById(id: String): Mono<Quote>
    fun findByAuthor(author: String): Flux<Quote>
    fun save(@Valid quote: Quote): Mono<Boolean>
}
