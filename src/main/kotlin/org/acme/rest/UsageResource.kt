package org.acme.rest

import org.acme.service.UsageService
import javax.ws.rs.GET
import javax.ws.rs.Path

data class GetUsageResponse(val mostUsedEndpoint: String, val counter: Int)

@Path("/usage")
class UsageResource(val usageService: UsageService) {

    /**
     * Returns a list of the used endpoint and the associate counter in a single element list
     * in case of equal usage of endpoints the response will be an unordered list of Endpoint usage
     */
    @GET
    fun getUsage(): MutableList<GetUsageResponse> {
        var mostUsedEndpoint: MutableList<GetUsageResponse> = mutableListOf()

        usageService.getUsage().forEach {
            if (mostUsedEndpoint.isEmpty())
                mostUsedEndpoint.add(GetUsageResponse(it.key, it.value))
            else if (mostUsedEndpoint[0].counter < it.value)
                mostUsedEndpoint = mutableListOf(GetUsageResponse(it.key, it.value))
            else if (mostUsedEndpoint[0].counter == it.value)
                mostUsedEndpoint.add(GetUsageResponse(it.key, it.value))
        }
        return mostUsedEndpoint
    }
}