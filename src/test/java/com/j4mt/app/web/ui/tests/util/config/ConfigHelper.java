package com.j4mt.app.web.ui.tests.util.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author j4mt
 *
 * Class to help with using propties set in properties files from the class loaded resourcces folder
 */
public class ConfigHelper {

    private String configFileName;
    private Properties properties;

    /**
     *
     * @param configFileName
     */
    public ConfigHelper(String configFileName) throws IOException {
        this.configFileName = configFileName;
        this.loadConfig(this.configFileName);
    }

    /**
     *
     * @param configFileName
     * @throws IOException
     */
    private void loadConfig(String configFileName) throws IOException {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(configFileName);
        if(inputStream != null){
            properties = new Properties();
            properties.load(inputStream);
        } else{
            throw new FileNotFoundException("Property File " + configFileName + " not found");
        }

    }

    /**
     *
     * @param propertyName
     * @return
     */
    public String getPropertyValue(String propertyName){
        return properties.getProperty(propertyName);
    }
}
