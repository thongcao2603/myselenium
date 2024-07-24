package org.example.utils;

import org.example.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {
    private PropertyUtils() {}

    private static Properties prop = new Properties();
    private static final Map<String,String> CONFIGMAP = new HashMap<>();

    static {
        try{
            FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
            prop.load(fis);

            for(Map.Entry<Object,Object> entry:prop.entrySet()){
                CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim());
            }
      //     prop.entrySet().forEach(entry -> CONFIGMAP.put(entry.getKey().toString(),entry.getValue().toString()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String get(String key) {

        if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.toLowerCase()))){
            try {
                throw new Exception("Property name " + key +" is not found.Plz check config.properties");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return CONFIGMAP.get(key);
    }

}
