package org.acme.UnitTests

import io.quarkus.test.junit.QuarkusTest
import org.acme.service.FizzBuzzParam
import org.acme.service.fizzBuzzed
import org.junit.jupiter.api.Test

@QuarkusTest
class FizzBuzzTest {
    @Test
    fun `fizzBuzzed basic`() {
        val fizzBuzzList = fizzBuzzed(
            FizzBuzzParam(3, "fizz"),
            FizzBuzzParam(5, "buzz"),
            (1..15).toList()
        )
        assert(fizzBuzzList == listOf("1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz"))
    }

    @Test
    fun `fizzBuzzed emptyEntryListParam`() {
        val fizzBuzzList = fizzBuzzed(
            FizzBuzzParam(3, "fizz"),
            FizzBuzzParam(5, "buzz"),
            listOf()
        )
        assert(fizzBuzzList == listOf<String>())
    }
}
