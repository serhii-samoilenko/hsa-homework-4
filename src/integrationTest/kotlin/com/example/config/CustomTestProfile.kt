package com.example.config

import io.quarkus.test.junit.QuarkusTestProfile

class CustomTestProfile : QuarkusTestProfile {
    override fun getConfigOverrides(): Map<String, String> =
        mapOf("quarkus.scheduler.enabled" to "false")
}
