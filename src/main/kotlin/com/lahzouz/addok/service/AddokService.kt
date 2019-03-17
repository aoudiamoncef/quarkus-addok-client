package com.lahzouz.addok.service

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.gson.gsonDeserializerOf
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import com.lahzouz.addok.domain.Addok
import com.lahzouz.addok.extension.logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AddokService {

    companion object {
        val log by logger()
    }

    @Autowired
    lateinit var fuelManager: FuelManager

    @Autowired
    lateinit var gson: Gson


    fun searchByAddress(query: String): String {
        val (request, response, result) = "/search".httpGet(listOf("q" to query))
                .responseObject(gsonDeserializerOf(Addok::class.java))

        with(log) {
            debug(request.toString())
            debug(response.toString())
            info(result.get().toString())
        }


        return gson.toJson(result.get())
    }
}
