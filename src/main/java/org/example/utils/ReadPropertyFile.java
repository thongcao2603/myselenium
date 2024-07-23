package org.example.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {
    private ReadPropertyFile() {}

    private static Properties prop = new Properties();
    private static final Map<String,String> CONFIGMAP = new HashMap<>();

    static {
        try{
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"/src/test/resources/config/config.properties");
            prop.load(fis);

            for(Map.Entry<Object,Object> entry:prop.entrySet()){
                CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()));
            }
//            prop.entrySet().forEach(entry -> CONFIGMAP.put(entry.getKey().toString(),entry.getValue().toString()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String get(String key) throws Exception {

        if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))){
            throw new Exception("Property name " + key +" is not found.Plz check config.properties");
        }
        return CONFIGMAP.get(key);
    }

}
