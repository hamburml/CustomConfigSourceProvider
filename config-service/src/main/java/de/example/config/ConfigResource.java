package de.example.config;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/config")
public class ConfigResource {

    @Inject
    ConfigResult configResult;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ConfigResult getConfig() {
        return configResult;
    }
}
