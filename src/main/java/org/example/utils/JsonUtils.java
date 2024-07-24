package org.example.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class JsonUtils {

    public Object[] getData() throws IOException {
        HashMap<String,Object> map1 = new ObjectMapper()
                .readValue(new File(System.getProperty("user.dir") + "/src/test/resources/data/data.json"),
                        new TypeReference<HashMap<String, Object>>() {});
        HashMap<String,Object> map2 = new ObjectMapper()
                .readValue(new File(System.getProperty("user.dir") + "/src/test/resources/data/data.json"),
                        new TypeReference<HashMap<String, Object>>() {});

        return new Object[]{map1, map2};
    }
}
