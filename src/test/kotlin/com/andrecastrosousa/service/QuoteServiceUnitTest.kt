package com.andrecastrosousa.service

import com.andrecastrosousa.model.Quote
import com.andrecastrosousa.repository.QuoteMongoRepository
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.bson.types.ObjectId
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@MicronautTest
class QuoteServiceUnitTest(
    private val quoteService: QuoteService,
    private val mongoRepository: QuoteMongoRepository
) {

    @Test
    fun `when get a list of quotes, should return an empty list`() {
        whenever(mongoRepository.findAll())
            .thenReturn(Flux.just(Quote("1", "test", "test", "test")))
        val quotes = quoteService.listAll().collectList().block()
        assertEquals(quotes?.size, 1)
    }

    @Test
    fun `when get a list of quotes of a specific author`() {
        whenever(mongoRepository.findByAuthor("Bill Gates"))
            .thenReturn(Flux.just(Quote("1", "test", "test", "test")))
        val quotes = quoteService.findByAuthor("Bill Gates").collectList().block()
        assertEquals(quotes?.size, 1)
    }

    @Test
    fun `when get a specific quote`() {
        whenever(mongoRepository.findById("1"))
            .thenReturn(Mono.just(Quote("1", "test", "test", "test")))
        val quote = quoteService.findById("1").block()
        assertEquals(quote?.id, "1")
    }


    @MockBean(QuoteMongoRepository::class)
    fun mongoRepository(): QuoteMongoRepository {
        return mock(QuoteMongoRepository::class.java)
    }
}