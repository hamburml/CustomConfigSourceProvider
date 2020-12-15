package de.example.config;

import io.smallrye.config.PropertiesConfigSource;
import org.eclipse.microprofile.config.spi.ConfigSource;
import org.eclipse.microprofile.config.spi.ConfigSourceProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import io.smallrye.common.classloader.ClassPathUtils;

public class CustomConfigSourceProvider implements ConfigSourceProvider {

    @Override
    public Iterable<ConfigSource> getConfigSources(ClassLoader classLoader) {
        List<ConfigSource> configs = new ArrayList<>();
        
        try {
            Properties configProperties = new Properties();

            ClassPathUtils.consumeAsStreams("more.properties", fileStream -> {
                try {
                    configProperties.load(fileStream);
                    configs.add(new PropertiesConfigSource(configProperties, "more.properties"));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            });
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return configs;
    }
}
