package com.andrecastrosousa.model

import io.micronaut.core.annotation.Creator
import jakarta.validation.constraints.NotBlank
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonProperty

data class Quote @Creator @BsonCreator constructor(
    @field:BsonProperty("quoteText") @param:BsonProperty("quoteText") @field:NotBlank val quote: String,
    @field:BsonProperty("quoteAuthor") @param:BsonProperty("quoteAuthor") @field:NotBlank val author: String,
    @field:BsonProperty("quoteGenre") @param:BsonProperty("quoteGenre") @field:NotBlank val genre: String
) {
}