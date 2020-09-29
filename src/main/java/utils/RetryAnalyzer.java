package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int count = 0;
    int limit = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < limit) {
            count++;
            return true;
        }
        return false;
    }
}
