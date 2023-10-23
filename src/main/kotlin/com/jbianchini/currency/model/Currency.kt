package com.jbianchini.currency.model

enum class Currency(val url: String) {
    USD("https://dolarapi.com/v1/dolares/oficial"),
    BLUE("https://dolarapi.com/v1/dolares/blue"),
    EUR("https://dolarapi.com/v1/cotizaciones/eur"),
    REAL("https://dolarapi.com/v1/cotizaciones/brl"),
    MEP("https://dolarapi.com/v1/dolares/bolsa");

    companion object {
        fun fromString(name: String): Currency {
            return values().firstOrNull { it.name == name } ?: throw IllegalArgumentException("Currency not found: $name")
        }
    }
}