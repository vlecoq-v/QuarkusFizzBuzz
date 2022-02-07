package org.acme.rest

import org.acme.service.FizzBuzzParam
import org.acme.service.fizzBuzzService
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

data class FizzBuzzRequest(
    @get:NotBlank
    val str1: String = "",
    @get:Min(1)
    val int1: Int = 1,
    @get:NotBlank
    val str2: String = "",
    @get:Min(1)
    val int2: Int = 1,
    @get:Min(1)
    val limit: Int = 1,
)

data class FizzBuzzResult(val fizzBuzzed: List<String>)

@Path("/fizzbuzz")
class FizzBuzzResource {

    /**
     * Returns a list of strings with numbers from 1 to limit, where: all multiples of int1 are replaced by str1, all
     * multiples of int2 are replaced by str2, all multiples of int1 and int2 are replaced by str1str2.
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
    fun fizzBuzzResource(@Valid req: FizzBuzzRequest): FizzBuzzResult {
        return FizzBuzzResult(
            fizzBuzzService(
                FizzBuzzParam(req.int1, req.str1),
                FizzBuzzParam(req.int2, req.str2),
                req.limit
            )
        )
    }
}
