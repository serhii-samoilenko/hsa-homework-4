package com.example.client

import com.example.dto.ExchangeRates
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.inject.Singleton
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.QueryParam

@Singleton
@RegisterRestClient(configKey = "coinbase")
interface CoinbaseClient {
    @GET
    @Path("/exchange-rates")
    fun getExchangeRatesForCurrency(@QueryParam("currency") currency: String): ExchangeRates
}
