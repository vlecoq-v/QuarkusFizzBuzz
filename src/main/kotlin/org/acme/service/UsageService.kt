package org.acme.service

import javax.enterprise.context.ApplicationScoped

/**
 *  Usage Service implements a private counter that can only be incremented via [inc] in [UsageFilter]
 */
@ApplicationScoped
class UsageService {
    private val usage: MutableMap<String, Int> = mutableMapOf()

    fun getUsage(): Map<String, Int> = usage.toMap()

    fun inc(path: String) {
        if (path !in usage)
            usage[path] = 1
        else
            usage[path] = usage[path]!! + 1
    }
}
