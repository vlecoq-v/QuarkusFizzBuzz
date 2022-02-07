package org.acme

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.acme.rest.FizzBuzzRequest
import org.junit.jupiter.api.Test
import javax.ws.rs.core.MediaType

@QuarkusTest
class FizzBuzzTest {
    @Test
    fun validRequest() {
        given()
            .`when`()
            .contentType(MediaType.APPLICATION_JSON)
            .body(FizzBuzzRequest("fizz", 1, "buzz", 5, 15))
            .post("/fizzbuzz")
            .then()
            .statusCode(200)
    }

    @Test
    fun invalidRequest() {
        given()
            .`when`()
            .contentType(MediaType.APPLICATION_JSON)
            .body(FizzBuzzRequest("fizz", 0, "buzz", 5, 15))
            .post("/fizzbuzz")
            .then()
            .statusCode(400)
    }
}
