package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int retryCount = 0;
    private int maxRetryCount = 3;
    @Override
    public boolean retry(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            retryCount++;
            if (retryCount >= maxRetryCount) {
                return true;
            }
        }
        return false;
    }
}
