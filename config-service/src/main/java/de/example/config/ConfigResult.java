package de.example.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ConfigResult {

    @Inject
    @ConfigProperty(name = "property")
    String property;

    public String getProperty() {
        return property;
    }
}
