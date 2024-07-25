package org.example.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.constants.FrameworkConstants;
import org.example.exceptions.FrameworkException;
import org.example.exceptions.InvalidPathFileException;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtils {
    private ExcelUtils() {
    }

    public static List<Map<String, String>> getTestDetails(String sheetName) {
        List<Map<String, String>> list;

        try (FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelPath())) {

            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            Sheet sheet = workbook.getSheet(sheetName);
            int rowNum = sheet.getLastRowNum();
            int colNum = sheet.getRow(0).getLastCellNum();

            Map<String, String> map = null;
            list = new ArrayList<>();

            for (int i = 1; i <= rowNum; i++) {
                map = new HashMap<>();
                for (int j = 0; j < colNum; j++) {
                    String key = MyUtils.getCellValueAsString(sheet.getRow(0).getCell(j));
                    String value = MyUtils.getCellValueAsString(sheet.getRow(i).getCell(j));
                    map.put(key, value);
                }
                list.add(map);
            }
            return list;
        } catch (FileNotFoundException e) {
            throw new InvalidPathFileException("Excel file not found");
        } catch (IOException e) {
            throw new FrameworkException("Some io exception happened when reading excel file");
        }
    }
}
