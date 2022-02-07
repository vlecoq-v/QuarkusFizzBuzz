package org.acme.service

data class FizzBuzzParam(
    val int: Int,
    val str: String
)

/**
 * Creates a list of Int from @param limit to apply fizzBuzzed function on each member
 * @result each subList of String is joined with @separator to be humanly readable
 */
fun fizzBuzzService(param1: FizzBuzzParam, param2: FizzBuzzParam, limit: Int, separator: String = " "): List<String> =
    (1..limit)
        .map { subLimit: Int ->
            fizzBuzzed(param1, param2, (1..subLimit).toList())
                .joinToString(separator)
        }

/**
 * @param entryList is a list of Int to be fizzBuzzed
 */
fun fizzBuzzed(param1: FizzBuzzParam, param2: FizzBuzzParam, entryList: List<Int>): List<String> =
    entryList
        .map {
            var fizzBuzzed: String = ""
            if (it % param1.int == 0) { fizzBuzzed += param1.str }
            if (it % param2.int == 0) { fizzBuzzed += param2.str }
            fizzBuzzed.ifBlank { it.toString() }
        }
