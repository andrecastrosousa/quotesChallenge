package com.andrecastrosousa.repository

import com.andrecastrosousa.config.MongoDbConfiguration
import com.andrecastrosousa.model.Quote
import com.mongodb.BasicDBObject
import com.mongodb.client.model.Filters.eq
import com.mongodb.client.model.IndexOptions
import com.mongodb.client.model.Indexes
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoCollection
import jakarta.annotation.PostConstruct
import jakarta.inject.Singleton
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.util.annotation.NonNull

@Singleton
class QuoteMongoRepository(
    private val mongoConfiguration: MongoDbConfiguration,
    private val mongoClient: MongoClient,
) : QuoteRepository {

    private val collection: MongoCollection<Quote>

    init {
        val db = mongoClient.getDatabase(mongoConfiguration.name)
        collection = db.getCollection(mongoConfiguration.collection, Quote::class.java)
    }

    @NonNull
    override fun findAll(): Flux<Quote> = Flux.from(collection.find())


    override fun findById(id: String): Mono<Quote> = Mono.from(collection.find(eq("_id", id)))

    override fun findByAuthor(author: String): Flux<Quote> =
        Flux.from(collection.find(eq("quoteAuthor", author)))

    override fun save(quote: Quote): Mono<Boolean> =
        Mono.from(collection.insertOne(quote))
            .map { true }
            .onErrorReturn(false)

    @PostConstruct
    fun onStartup() {
        val weights = BasicDBObject("quoteAuthor", 10)

        collection.createIndex(Indexes.text("quoteAuthor"), IndexOptions().weights(weights))
    }
}