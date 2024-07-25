package org.example.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {
    private static List<Map<String, String>> list = new ArrayList<>();

    @DataProvider
    public static  Object[] getData(Method m) throws IOException {
        String testName = m.getName();
        if(list.isEmpty()){
            list =ExcelUtils.getTestDetails("DATA");
        }

        List<Map<String,String>> smallList = new ArrayList<>();

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).get("testname").equalsIgnoreCase(testName)){
                if(list.get(i).get("execute").equalsIgnoreCase("yes")){
                    smallList.add(list.get(i));
                }
            }
        }
        return smallList.toArray();
    }
}
