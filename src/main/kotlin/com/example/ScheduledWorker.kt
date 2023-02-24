package com.example

import com.example.client.CoinbaseClient
import com.example.client.GampV4Client
import com.example.config.AppConfig
import com.example.dto.Crypto
import com.example.dto.Event
import com.example.dto.Fiat
import com.example.dto.GampMetrics
import io.quarkus.logging.Log
import io.quarkus.scheduler.Scheduled
import org.eclipse.microprofile.rest.client.inject.RestClient
import javax.enterprise.context.ApplicationScoped
import kotlin.random.Random

@ApplicationScoped
class ScheduledWorker(
    private val config: AppConfig,
    @RestClient
    private val coinbaseClient: CoinbaseClient,
    @RestClient
    private val gampClient: GampV4Client
) {
    companion object {
        private val clientId = Random.nextInt(100000000, 999999999).toString()
    }

    @Scheduled(every = "{app.scheduler-rate}")
    fun main() {
        val events = Crypto.values().map { getCurrencyPairs(it.toString(), Fiat.set) }
        val metrics = GampMetrics(clientId, events)
        gampClient.postEvents(config.measurementId(), config.apiSecret(), metrics)
        Log.info("Sent events: ${events.map { it.name }}")
    }

    fun getCurrencyPairs(source: String, target: Set<String>): Event {
        val rates = coinbaseClient.getExchangeRatesForCurrency(source)
        val currency: String = rates.data.currency
        val pairs: Map<String, String> = rates.data.rates
            .filter { target.contains(it.key) }
            .map { (crypto, rate) -> Pair(crypto, rate.toString()) }
            .toMap()
        Log.info("Got ${pairs.keys} crypto rates for $currency")
        return Event(name = "${currency}_rate", params = pairs)
    }
}
