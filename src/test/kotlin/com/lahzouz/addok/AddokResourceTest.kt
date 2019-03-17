package com.lahzouz.addok

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@QuarkusTest
open class AddokResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
                .log().all()
                .`when`().get("/hello")
                .then()
                .statusCode(200)
                .body(`is`("Hello to Kotlin BBL"))
    }

    @Test
    fun testHelloEndpointWithKotlinDSL() {
        given {
            log().all()
            on {
                get("/hello").then {
                    statusCode(200)
                    body(`is`("Hello to Kotlin BBL"))
                }
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["4 Allée du Château Blanc, 59290 Wasquehal"])
    fun testSearchEndpoint(query: String) {
        given()
                .log().all()
                .queryParam("query", query)
                .`when`().get("/search")
                .then()
                .statusCode(200)
                .body("query", equalTo(query))
    }

    @ParameterizedTest
    @ValueSource(strings = ["19 Avenue Saint-Maur, 59110 La Madeleine"])
    fun testSearchEndpointKotlinDSL(query: String) {

        given {
            log().all()
            queryParam("query", query)
            on {
                get("/search") then {
                    statusCode(200)
                    body("query", equalTo(query))
                }
            }
        }
    }


}