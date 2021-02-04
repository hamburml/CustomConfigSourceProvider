package de.example.config;

import io.smallrye.config.PropertiesConfigSource;
import org.eclipse.microprofile.config.spi.ConfigSource;
import org.eclipse.microprofile.config.spi.ConfigSourceProvider;
import org.jboss.logging.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import io.smallrye.common.classloader.ClassPathUtils;

public class CustomConfigSourceProvider implements ConfigSourceProvider {


    private static final Logger logger = Logger.getLogger(CustomConfigSourceProvider.class);

    @Override
    public Iterable<ConfigSource> getConfigSources(ClassLoader classLoader) {
        List<ConfigSource> configs = new ArrayList<>();
        logger.info("--- CustomConfigSourceProvider ---");

        try {
            Properties configProperties = new Properties();

            String propertyPrefix = this.getPropertyPrefix();

            logger.info("propertyPrefix: " + propertyPrefix);
            if(propertyPrefix == null)
                propertyPrefix = "";

            String file = propertyPrefix + "stage.properties";
            logger.info("use property file: " + file);
            ClassPathUtils.consumeAsStreams(file, fileStream -> {
                try {
                    configProperties.load(fileStream);
                    configs.add(new PropertiesConfigSource(configProperties, ""));
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

    private String getPropertyPrefix()
    {
        return System.getProperty("stage");
    }
}
