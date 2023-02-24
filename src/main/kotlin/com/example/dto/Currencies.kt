package com.example.dto

enum class Crypto {
    BTC, ETH, DOGE;

    companion object {
        val list = values().map { it.name }
    }
}

enum class Fiat {
    USD, EUR, UAH;

    companion object {
        val list = Fiat.values().map { it.name }
    }
}
