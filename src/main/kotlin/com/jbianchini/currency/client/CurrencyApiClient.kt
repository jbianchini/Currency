package com.jbianchini.currency.client

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class CurrencyApiClient {
    fun getDataFromAPIWebClient(url: String): Mono<CurrencyApiResponse> {

        return WebClient.create()
            .get()
            .uri(url) // Reemplaza con la ruta de la API que deseas consultar
            .retrieve()
            .bodyToMono(CurrencyApiResponse::class.java)
    }
}