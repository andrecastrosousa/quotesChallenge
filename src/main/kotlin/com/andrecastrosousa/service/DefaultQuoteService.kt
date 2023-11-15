package com.andrecastrosousa.service

import com.andrecastrosousa.model.Quote
import com.andrecastrosousa.repository.QuoteRepository
import java.util.concurrent.Flow.Publisher

class DefaultQuoteService(private val quoteRepository: QuoteRepository): QuoteService {
    override fun listAll(): Publisher<List<Quote>> {
        return quoteRepository.findAll()
    }

    override fun findById(id: String): Publisher<Quote> {
        return quoteRepository.findById(id)
    }

    override fun findByAuthor(author: String?): Publisher<List<Quote>> {
        return quoteRepository.findByAuthor(author!!)
    }
}