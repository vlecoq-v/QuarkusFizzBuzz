package org.acme.IntegrationTests

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test
import javax.ws.rs.core.MediaType

/** matching this endpoint is not very useful as its content will vary with previous tests, therefore it is just printed during test
 * use `Make test.info` to see the results
 */
@QuarkusTest
class UsageTest {
    @Test
    fun usageTest() {
        println(
            given()
                .`when`()
                .contentType(MediaType.APPLICATION_JSON)
                .get("/usage")
                .then()
                .statusCode(200)
                .extract()
                .asPrettyString()
        )
    }
}
