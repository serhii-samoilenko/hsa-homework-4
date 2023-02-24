package com.example.dto

enum class Fiat {
    USD, EUR, UAH;

    companion object {
        val set = Fiat.values().map { it.name }.toSet()
    }
}
