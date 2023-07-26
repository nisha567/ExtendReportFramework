package org.example.selenium.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RunFailedTests implements IRetryAnalyzer {
    @Override
    public boolean retry(ITestResult iTestResult) {

        return false;
    }
}
