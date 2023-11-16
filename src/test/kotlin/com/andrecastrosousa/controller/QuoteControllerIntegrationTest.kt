package com.andrecastrosousa.controller

import com.andrecastrosousa.model.Quote
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

@MicronautTest
class QuoteControllerIntegrationTest(@Client("/") val client: HttpClient) {
    @Test
    fun `Should get a quote by ID`() {
        val e = Executable { client.toBlocking().exchange<Any, Any>(HttpRequest.GET<Any>("/")) }

        val thrown = assertThrows(HttpClientResponseException::class.java, e)
        assertEquals(HttpStatus.NOT_FOUND, thrown.status)
    }

    @Test
    fun `Should get a list of quotes`() {
        val body = client.toBlocking().exchange<Quote, Any>(
            HttpRequest.GET("/api/quotes"))

        assertNotNull(body)
    }

    @Test
    fun `Should get quotes by author name`() {
        val body = client.toBlocking().exchange<List<Quote>, Any>(
            HttpRequest.GET("/api/quotes/search?author=Bill%20Gates"))

        println(body)
        assertNotNull(body)
    }
}