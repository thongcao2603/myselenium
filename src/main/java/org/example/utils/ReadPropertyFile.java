package org.example.utils;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {
    private ReadPropertyFile() {}

    public static String getValue(String key) throws Exception {
        String value = null;
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"/src/test/resources/config/config.properties");
        Properties prop = new Properties();
        prop.load(fis);
        value=prop.getProperty(key);
        if(Objects.isNull(value)){
            throw new Exception("Property name " + key +" is not found.Plz check config.properties");
        }
        return prop.getProperty(key);
    }
}
