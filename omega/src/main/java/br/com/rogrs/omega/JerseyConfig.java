package br.com.rogrs.omega;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        // scan the resources package for our resources
        packages(getClass().getPackage().getName() + ".resources");
    }
}