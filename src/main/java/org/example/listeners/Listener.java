package org.example.listeners;

import org.testng.*;
import org.example.reports.ExtentLogger;
import org.example.reports.ExtentReport;

import java.util.Arrays;

public class Listener implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        try {
            ExtentReport.initReports();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName()+ " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName()+ " is failed",true);
        ExtentLogger.fail(result.getThrowable().toString());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName()+ " is skipped");
    }

    //dont use
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
