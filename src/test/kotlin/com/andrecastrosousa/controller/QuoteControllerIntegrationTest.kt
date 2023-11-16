package com.andrecastrosousa.controller

import com.andrecastrosousa.model.Quote
import com.andrecastrosousa.repository.QuoteRepository
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.bson.types.ObjectId
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

@MicronautTest
class QuoteControllerIntegrationTest(@Client("/") val client: HttpClient, private val mongoRepository: QuoteRepository) {
    @Test
    fun `Should get a list of quotes`() {
        val body = client.toBlocking().exchange(
            HttpRequest.GET<Quote>("/api/quotes"),
            Argument.listOf(Quote::class.java))

        assertNotNull(body)
        assertEquals(HttpStatus.OK, body.status)
        assertEquals(body.body().size, 3)
    }

    @Test
    fun `Should get quotes by author name`() {
        val body = client.toBlocking().exchange(
            HttpRequest.GET<Quote>("/api/quotes"),
            Argument.listOf(Quote::class.java))

        assertNotNull(body)
        assertEquals(HttpStatus.OK, body.status)
    }

    @Test
    fun `Should get an error to request find quote with nonexistentID`() {
        val e = Executable {
            val body = client.toBlocking().exchange(
                HttpRequest.GET<Quote>("/api/quotes/1"),
                Argument.of(Quote::class.java))

        }

        val thrown = assertThrows(HttpClientResponseException::class.java, e)
        assertEquals(HttpStatus.NOT_FOUND, thrown.status)
    }
}