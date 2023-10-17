package com.jbianchini.currency.controller

data class CurrencyRequestBody (
    val baseCurrency: String?,
    val targetCurrency: String?
)