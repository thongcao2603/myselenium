package org.example.listeners;

import org.example.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {

    private int retryCount = 0;
    private int maxRetryCount = 3;
    @Override
    public boolean retry(ITestResult result) {
        boolean value = false;
        if(PropertyUtils.get("retryfailedtest").equalsIgnoreCase("yes")){
            value = retryCount<maxRetryCount;
            retryCount++;
        }
        return false;
    }
}
