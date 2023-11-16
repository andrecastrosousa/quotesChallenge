package com.andrecastrosousa.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Creator
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.constraints.NotBlank
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import org.bson.types.ObjectId

@Serdeable
@Introspected
data class Quote @Creator @BsonCreator constructor(
    @JsonProperty("quote") @BsonProperty("quoteText") val quote: String,
    @JsonProperty("author") @BsonProperty("quoteAuthor") val author: String,
    @JsonProperty("genre") @BsonProperty("quoteGenre") val genre: String
) {
}