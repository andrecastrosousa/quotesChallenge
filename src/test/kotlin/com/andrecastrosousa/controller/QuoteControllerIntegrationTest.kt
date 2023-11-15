package com.andrecastrosousa.controller

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

@MicronautTest
class QuoteControllerIntegrationTest(@Client("/") val client: HttpClient) {
    @Test
    fun `Should get a quote by ID`() {
        val request: HttpRequest<Any> = HttpRequest.GET("/api/quotes/1")
        val body = client.toBlocking().retrieve(request)

        println(body)
        assertNotNull(body)
    }

    @Test
    fun `Should get a list of quotes`() {
        val request: HttpRequest<Any> = HttpRequest.GET("/api/quotes")
        val body = client.toBlocking().retrieve(request)

        assertNotNull(body)
    }

    @Test
    fun `Should get quotes by author name`() {
        val request: HttpRequest<Any> = HttpRequest.GET("/api/quotes/search?author=Bill%20Gates")
        val body = client.toBlocking().retrieve(request)

        println(body)
        assertNotNull(body)
    }
}