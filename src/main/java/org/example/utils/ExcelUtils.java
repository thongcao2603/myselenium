package org.example.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtils {

    public Object[] getData() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/data/auto.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheet("DATA");
        int rowNum = sheet.getLastRowNum();
        int colNum = sheet.getRow(0).getLastCellNum();

        Object[] data = new Object[rowNum];
        Map<String, String> map;

        for(int i = 1; i <= rowNum; i++) {
            map = new HashMap<>();
            for(int j = 0; j < colNum; j++) {
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value);
                data[i]=map;
            }
        }
        return data;
    }
}
