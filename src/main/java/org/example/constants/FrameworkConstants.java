package org.example.constants;

public class FrameworkConstants {
    private FrameworkConstants() {}

    private static final String CONFIGFILEPATH = System.getProperty("user.dir") +"/src/test/resources/config/config.properties";
    private static final int EXPLICITWAIT = 3;

    public static int getExplicitWait(){
        return EXPLICITWAIT;
    }

    public static String getConfigFilePath(){
        return CONFIGFILEPATH;
    }
}
