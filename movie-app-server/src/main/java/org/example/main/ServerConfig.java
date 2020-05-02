package org.example.main;

import org.example.security.annotation.AuthenticateFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class ServerConfig extends ResourceConfig {
    public ServerConfig() {
        register(AuthenticateFilter.class);
    }
}
