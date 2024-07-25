package org.example.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.example.constants.FrameworkConstants;
import org.example.enums.CategoryType;

import java.util.Objects;

public final class ExtentReport {
    private ExtentReport() {
    }

    private static ExtentReports extent;
    public static ExtentTest test;

    public static void initReports() throws Exception {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportPath());

            extent.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Report");
            spark.config().setReportName("Report");

        }
    }

    public static void flushReport() {
        if(Objects.nonNull(extent)){
            extent.flush();
        }
        ExtentManager.closeExtentTest();
    }

    public static void createTest(String testcaseName) {
        ExtentManager.setTest(extent.createTest(testcaseName));
    }

    public static void addAuthors(String[] authors){
        for(String temp:authors){
            ExtentManager.getTest().assignAuthor(temp);
        }
    }

    public static void addCategories(CategoryType[] categories){
        for(CategoryType temp:categories){
            ExtentManager.getTest().assignCategory(temp.toString());
        }
    }
}
