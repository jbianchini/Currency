package com.jbianchini.currency.service

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class CurrencyService {
    private val url = "https://dolarapi.com/v1/dolares/blue"

    fun getDataFromAPIWebClient(): String {
        val webClient = WebClient.create(url)

        val responseMono: Mono<String> = webClient
            .get()
            .uri("") // Reemplaza con la ruta de la API que deseas consultar
            .retrieve()
            .bodyToMono(String::class.java)

        val response = responseMono.block() // Bloquear para obtener el resultado de manera síncrona

        return response ?: "No se pudo obtener datos de la API"
    }
}