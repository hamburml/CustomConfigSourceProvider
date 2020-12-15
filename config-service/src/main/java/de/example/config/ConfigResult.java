package de.example.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ConfigResult {

    @Inject
    @ConfigProperty(name = "test.property")
    String applicationPropertiesProperty;

    @Inject
    @ConfigProperty(name = "more.property")
    String providerProperty;

    public String getApplicationPropertiesProperty() {
        return applicationPropertiesProperty;
    }

    public String getProviderProperty() {
        return providerProperty;
    }
}
