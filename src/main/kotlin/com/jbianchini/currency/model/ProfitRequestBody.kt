package com.jbianchini.currency.model

data class ProfitRequestBody(
    val amount: Double?,
    val baseCurrency: String?,
    val targetCurrency: String?
)