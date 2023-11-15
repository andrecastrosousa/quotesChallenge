package com.andrecastrosousa.service

import com.andrecastrosousa.model.Quote
import com.andrecastrosousa.repository.QuoteRepository
import java.util.concurrent.Flow.Publisher

class DefaultQuoteService(private val quoteRepository: QuoteRepository): QuoteService {
    override fun listAll(): Publisher<List<Quote>> {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): Publisher<Quote> {
        TODO("Not yet implemented")
    }

    override fun findByAuthor(author: String?): Publisher<List<Quote>> {
        TODO("Not yet implemented")
    }
}