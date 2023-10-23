package com.jbianchini.currency.service

import com.jbianchini.currency.client.CurrencyApiClient
import com.jbianchini.currency.model.Currency
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CurrencyService(
    private val currencyApiClient: CurrencyApiClient
) {
    fun calculateProfit(amount: Double, baseCurrency: Currency, targetCurrency: Currency): Mono<Double> {
        val baseCurrencyMono = currencyApiClient.getDataFromAPIWebClient(baseCurrency.url)
        val targetCurrencyMono = currencyApiClient.getDataFromAPIWebClient(targetCurrency.url)

        return baseCurrencyMono
            .zipWith(targetCurrencyMono)
            .flatMap { tuple ->
                val baseCurrencyValue = tuple.t1
                val targetCurrencyValue = tuple.t2

                val profit = amount / baseCurrencyValue.venta * targetCurrencyValue.compra
                Mono.just(profit)
            }
    }


}