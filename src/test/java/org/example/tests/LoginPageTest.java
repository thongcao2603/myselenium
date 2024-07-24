package org.example.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.api.Assertions;

import org.example.pages.HomePage;
import org.example.pages.LoginPage;

import org.example.utils.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginPageTest extends BaseTest{

    private LoginPageTest(){}

    @Test(dataProvider = "getData")
    public void test1(Map<String,Object> map) {
        map.forEach((k,v)->System.out.println(k+":"+v));
    }

    @DataProvider
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
