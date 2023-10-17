package com.jbianchini.currency.controller

import com.jbianchini.currency.service.CurrencyService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping("/currency")
class CurrencyController(
    private val currencyService: CurrencyService
) {

    @PostMapping("/get_currency")
    @ResponseBody
    fun getCurrencyWeb(@RequestBody body: CurrencyRequestBody): String {

        val responseWebClient = currencyService.getDataFromAPIWebClient()

        val response = "Base currency: ${body.baseCurrency}. Target currency: ${body.targetCurrency}"

        return "$response \n $responseWebClient"
    }

}