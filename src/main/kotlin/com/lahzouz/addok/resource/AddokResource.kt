package com.lahzouz.addok.resource

import com.lahzouz.addok.service.AddokService
import org.springframework.beans.factory.annotation.Autowired
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/")
class AddokResource {

    @Autowired
    lateinit var addokService: AddokService

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello to Kotlin BBL"

    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    fun search(@QueryParam("query") query: String) = addokService.searchByAddress(query)
}