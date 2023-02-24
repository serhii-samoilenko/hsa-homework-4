package com.example.dto

enum class Crypto {
    BTC, ETH, DOGE;

    companion object {
        val set = values().map { it.name }.toSet()
    }
}
