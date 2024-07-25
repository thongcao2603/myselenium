package org.example.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager  {
    private ExtentManager() {

    }

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return test.get();
    }
    static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    static void closeExtentTest() {
        test.remove();
    }
}
