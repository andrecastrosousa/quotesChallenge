package com.andrecastrosousa.service

import com.andrecastrosousa.exception.AuthorRequiredException
import com.andrecastrosousa.model.Quote
import com.andrecastrosousa.repository.QuoteRepository
import jakarta.inject.Singleton
import org.reactivestreams.Publisher
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Singleton
class DefaultQuoteService(private val quoteRepository: QuoteRepository): QuoteService {
    override fun listAll(): Flux<Quote> {
        return quoteRepository.findAll()
    }

    override fun findById(id: String): Mono<Quote> {
        return quoteRepository.findById(id)
    }

    override fun findByAuthor(author: String?): Flux<Quote> {
        if(author == null) throw AuthorRequiredException("Author name is necessary.")
        return quoteRepository.findByAuthor(author)
    }
}