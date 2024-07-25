package org.example.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtils {
    private ExcelUtils() {}

    public static  Object[] getData() throws IOException {
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

    public static List<Map<String,String>> getTestDetails(){
        List<Map<String,String>> list;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(FrameworkConstants.getExcelPath());
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            Sheet sheet = workbook.getSheet("RUNMANAGER");
            int rowNum = sheet.getLastRowNum();
            int colNum = sheet.getRow(0).getLastCellNum();

            Map<String, String> map=null;
            list=new ArrayList<>();

            for(int i = 1; i <= rowNum; i++) {
                map = new HashMap<>();
                for(int j = 0; j < colNum; j++) {
                    String key = MyUtils.getCellValueAsString(sheet.getRow(0).getCell(j));
                    String value = MyUtils.getCellValueAsString(sheet.getRow(i).getCell(j));
                    map.put(key, value);
                }
                list.add(map);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(Objects.nonNull(fis)){
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }
}
