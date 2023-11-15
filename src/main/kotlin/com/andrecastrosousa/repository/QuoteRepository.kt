package com.andrecastrosousa.repository

import com.andrecastrosousa.model.Quote
import jakarta.validation.Valid
import reactor.core.publisher.Mono
import java.util.concurrent.Flow.Publisher

interface QuoteRepository {
    fun findAll(): Publisher<List<Quote>>
    fun findById(id: String): Publisher<Quote>
    fun findByAuthor(author: String): Publisher<List<Quote>>
    fun save(@Valid quote: Quote): Mono<Boolean>
}