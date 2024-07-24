package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;

public final class ExtentReport {
    private ExtentReport() {
    }

    private static ExtentReports extent;
    public static ExtentTest test;

    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("index.html");

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
    }

    public static void createTest(String testcaseName) {
        ExtentManager.setTest(extent.createTest(testcaseName));
    }
}
