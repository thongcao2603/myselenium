package org.example.constants;

public class FrameworkConstants {
    private FrameworkConstants() {}

    private static final String CONFIGFILEPATH = System.getProperty("user.dir") +"/src/test/resources/config/config.properties";

    public static String getConfigFilePath(){
        return CONFIGFILEPATH;
    }
}
