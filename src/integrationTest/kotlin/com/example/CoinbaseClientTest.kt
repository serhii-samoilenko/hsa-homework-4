package com.example

import com.example.client.CoinbaseClient
import com.example.config.CustomTestProfile
import com.example.dto.Fiat
import io.quarkus.test.junit.QuarkusTest
import io.quarkus.test.junit.TestProfile
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@QuarkusTest
@TestProfile(CustomTestProfile::class)
class CoinbaseClientTest {

    @RestClient
    private lateinit var client: CoinbaseClient

    @Test
    fun testExtensionsIdEndpoint() {
        // Given
        val currency = Fiat.USD.name
        // When
        val actual = client.getExchangeRatesForCurrency(currency)
        // Then
        println(actual)
        assertEquals(actual.data.currency, currency)
    }
}
