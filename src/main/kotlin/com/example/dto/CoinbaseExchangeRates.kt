package com.example.dto

data class ExchangeRates(
    val data: Data
)

data class Data(
    val currency: String,
    val rates: Map<String, Double>
)
