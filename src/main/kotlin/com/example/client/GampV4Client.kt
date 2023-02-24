package com.example.client

import com.example.dto.GampMetrics
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.inject.Singleton
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.QueryParam

@Singleton
@RegisterRestClient(configKey = "gamp4")
interface GampV4Client {
    @POST
    @Path("/mp/collect")
    fun postEvents(
        @QueryParam("measurement_id") measurementId: String,
        @QueryParam("api_secret") apiSecret: String,
        events: GampMetrics
    )

    @POST
    @Path("/debug/mp/collect")
    fun debugEvents(
        @QueryParam("measurement_id") measurementId: String,
        @QueryParam("api_secret") apiSecret: String,
        events: GampMetrics
    )
}
