package com.example.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class GampMetrics(
    @JsonProperty("client_id")
    val clientId: String,
    val events: List<Event>
)

data class Event(
    val name: String,
    val params: Map<String, String>
)
