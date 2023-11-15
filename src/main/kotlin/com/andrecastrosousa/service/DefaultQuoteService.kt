package com.andrecastrosousa.service

import com.andrecastrosousa.model.Quote
import java.util.concurrent.Flow

class DefaultQuoteService: QuoteService {
    override fun listAll(): Flow.Publisher<List<Quote>> {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): Flow.Publisher<Quote> {
        TODO("Not yet implemented")
    }

    override fun findByAuthor(author: String?): Flow.Publisher<List<Quote>> {
        TODO("Not yet implemented")
    }
}