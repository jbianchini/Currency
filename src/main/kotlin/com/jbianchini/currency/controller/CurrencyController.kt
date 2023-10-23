package com.jbianchini.currency.controller

import com.jbianchini.currency.model.Currency
import com.jbianchini.currency.model.ProfitRequestBody
import com.jbianchini.currency.service.CurrencyService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono


@Controller
@RequestMapping("/currency")
class CurrencyController(
    private val currencyService: CurrencyService
) {

    @PostMapping("/get_currency")
    @ResponseBody
    fun getCurrencyWeb(@RequestBody body: ProfitRequestBody): Mono<String> {
        val amount = body.amount!!
        val baseCurrency = Currency.fromString(body.baseCurrency!!)
        val targetCurrency = Currency.fromString(body.targetCurrency!!)

        return currencyService.calculateProfit(amount, baseCurrency, targetCurrency)
            .map { profit ->
                val formattedProfit = "%.2f".format(profit)
                "Monto inicial: $amount. Compra: ${body.baseCurrency}. Vende: ${body.targetCurrency}\n" +
                        "El rendimiento final son $$formattedProfit."
            }
    }

}