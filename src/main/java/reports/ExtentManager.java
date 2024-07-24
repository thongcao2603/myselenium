package reports;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class ExtentManager  {
    private ExtentManager() {

    }

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return test.get();
    }
    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    public static void closeExtentTest() {
        test.remove();
    }
}
