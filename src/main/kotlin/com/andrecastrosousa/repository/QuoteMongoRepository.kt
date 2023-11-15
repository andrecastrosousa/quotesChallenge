package com.andrecastrosousa.repository

import com.andrecastrosousa.config.MongoDbConfiguration
import com.andrecastrosousa.model.Quote
import com.mongodb.reactivestreams.client.MongoClient
import reactor.core.publisher.Mono
import java.util.concurrent.Flow

class QuoteMongoRepository(
    private val mongoConfiguration: MongoDbConfiguration,
    private val mongoClient: MongoClient,
) : QuoteRepository {
    override fun findAll(): Flow.Publisher<List<Quote>> {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): Flow.Publisher<Quote> {
        TODO("Not yet implemented")
    }

    override fun findByAuthor(author: String): Flow.Publisher<List<Quote>> {
        TODO("Not yet implemented")
    }

    override fun save(quote: Quote): Mono<Boolean> {
        TODO("Not yet implemented")
    }

}