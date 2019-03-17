package com.lahzouz.addok.config

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Request
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Value("\${addok.url}")
    lateinit var addokUrl: String

    @Bean
    fun gson() = Gson()

    @Bean
    fun fuelManager(): FuelManager {
        return FuelManager.instance.apply {
            basePath = addokUrl
            addRequestInterceptor(tokenInterceptor())
        }
    }

    private fun tokenInterceptor() = { next: (Request) -> Request ->
        { req: Request ->
            req.header(mapOf("Authorization" to "Kotlin BBL"))
            next(req)
        }
    }
}
