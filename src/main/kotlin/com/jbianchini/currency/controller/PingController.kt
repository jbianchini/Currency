package com.jbianchini.currency.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/ping")
class PingController {

    @GetMapping
    @ResponseBody
    fun ping(): String {
        return "pong"
    }
}