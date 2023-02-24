package com.example.config

import io.smallrye.config.ConfigMapping
import io.smallrye.config.WithName

@ConfigMapping(prefix = "app")
interface AppConfig {

    @WithName("scheduler-rate")
    fun schedulerRate(): String

    @WithName("measurement-id")
    fun measurementId(): String

    @WithName("api-secret")
    fun apiSecret(): String
}
