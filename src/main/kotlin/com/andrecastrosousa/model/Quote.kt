package com.andrecastrosousa.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Creator
import io.micronaut.serde.annotation.Serdeable
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty

@Serdeable
data class Quote @Creator @BsonCreator constructor(
    @BsonId @JsonProperty("id") @BsonProperty("id") val id: String,
    @JsonProperty("quote") @BsonProperty("quoteText") val quote: String,
    @JsonProperty("author") @BsonProperty("quoteAuthor") val author: String,
    @JsonProperty("genre") @BsonProperty("quoteGenre") val genre: String,
) {
}