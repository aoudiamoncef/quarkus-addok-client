package com.lahzouz.addok

import io.restassured.RestAssured
import io.restassured.response.Validatable
import io.restassured.response.ValidatableResponseOptions
import io.restassured.specification.RequestSender
import io.restassured.specification.RequestSpecification

internal fun given(block: RequestSpecification.() -> Unit): RequestSpecification = RestAssured.given().apply(block)
internal fun RequestSpecification.on(block: RequestSender.() -> Unit): RequestSender = this.`when`().apply(block)
internal fun RequestSpecification.jsonBody(body: Any): RequestSender = this.contentType(io.restassured.http.ContentType.JSON).body(body)
internal infix fun Validatable<*, *>.then(block: ValidatableResponseOptions<*, *>.() -> Unit): ValidatableResponseOptions<*, *> = this.then().apply(block)
