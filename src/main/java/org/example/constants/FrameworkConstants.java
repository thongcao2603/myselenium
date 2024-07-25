package org.example.constants;

import org.apache.logging.log4j.util.PropertiesUtil;
import org.example.utils.PropertyUtils;

public class FrameworkConstants {
    private FrameworkConstants() {}

    private static final String CONFIGFILEPATH = System.getProperty("user.dir") +"/src/test/resources/config/config.properties";
    private static final int EXPLICITWAIT = 15;
    private static final String EXTENTREPORTPATH=System.getProperty("user.dir")+"/extent-test-output/";
    private static final String EXCELPATH=System.getProperty("user.dir")+"/src/test/resources/data/auto.xlsx";

    public static String getExcelPath(){
        return EXCELPATH;
    }

    public static String getExtentReportPath() throws Exception {
        if (PropertyUtils.get("overridereports").equalsIgnoreCase("no")){
            return EXTENTREPORTPATH+"/" +System.currentTimeMillis()+"/index.html";
        }
        return EXTENTREPORTPATH+"/index.html";
    }


    public static int getExplicitWait(){
        return EXPLICITWAIT;
    }

    public static String getConfigFilePath(){
        return CONFIGFILEPATH;
    }
}
