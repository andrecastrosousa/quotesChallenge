package com.andrecastrosousa.service

import com.andrecastrosousa.model.Quote
import java.util.concurrent.Flow.Publisher

interface QuoteService {
    fun listAll(): Publisher<List<Quote>>
    fun findById(id: String): Publisher<Quote>
    fun findByAuthor(author: String?): Publisher<List<Quote>>
}