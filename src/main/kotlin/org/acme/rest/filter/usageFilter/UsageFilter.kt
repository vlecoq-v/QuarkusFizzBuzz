package org.acme.rest.filter.usageFilter

import org.acme.service.UsageService
import javax.annotation.Priority
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ContainerRequestFilter
import javax.ws.rs.container.PreMatching
import javax.ws.rs.core.Context
import javax.ws.rs.core.UriInfo
import javax.ws.rs.ext.Provider

/**
 * A filter matching all endpoints that increments [UsageService.usage]
 */
@Provider
@Priority(1)
@PreMatching
@ApplicationScoped
class UsageFilter(val usageService: UsageService): ContainerRequestFilter {
    @Context var info: UriInfo? = null

    override fun filter(context: ContainerRequestContext) = usageService.inc(info!!.path)
}
