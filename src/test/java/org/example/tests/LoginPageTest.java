package org.example.tests;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.api.Assertions;

import org.example.pages.HomePage;
import org.example.pages.LoginPage;

import org.example.utils.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginPageTest extends BaseTest{

    private LoginPageTest(){}

    @Test(dataProvider = "getDataLogin")
    public void test1(Map<String,String> map) {
        System.out.println(map.get("password"));
    }

    @DataProvider(name = "getDataLogin",parallel = true)
    public Object[] getData() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/data/auto.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheet("DATA");
        int rowNum = sheet.getLastRowNum();
        System.out.println(rowNum);
        int colNum = sheet.getRow(0).getLastCellNum();

        Object[] data = new Object[rowNum];
        Map<String, String> map;

        for(int i = 1; i <= rowNum; i++) {
            map = new HashMap<>();
            for(int j = 0; j < colNum; j++) {
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value);
                data[i-1]=map;
            }
        }
        return data;
    }

}
