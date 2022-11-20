package org.acme.IntegrationTests

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.acme.rest.FizzBuzzRequest
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.Test
import javax.ws.rs.core.MediaType

@QuarkusTest
class FizzBuzzTest {
    @Test
    fun validRequest() {
        given()
            .`when`()
            .contentType(MediaType.APPLICATION_JSON)
            .body(FizzBuzzRequest("fizz", 3, "buzz", 5, 15))
            .post("/fizzbuzz")
            .then()
            .statusCode(200)
            .body("fizzBuzzed", CoreMatchers.`is`("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz"))
    }

    @Test
    fun invalidIntParam() {
        given()
            .`when`()
            .contentType(MediaType.APPLICATION_JSON)
            .body(FizzBuzzRequest("fizz", 0, "buzz", 5, 15))
            .post("/fizzbuzz")
            .then()
            .statusCode(400)
    }

    @Test
    fun invalidLimitParam() {
        given()
            .`when`()
            .contentType(MediaType.APPLICATION_JSON)
            .body(FizzBuzzRequest("fizz", 3, "buzz", 5, -1))
            .post("/fizzbuzz")
            .then()
            .statusCode(400)
    }

    @Test
    fun invalidWordParam() {
        given()
            .`when`()
            .contentType(MediaType.APPLICATION_JSON)
            .body(FizzBuzzRequest("", 3, "buzz", 5, -1))
            .post("/fizzbuzz")
            .then()
            .statusCode(400)
    }
}
