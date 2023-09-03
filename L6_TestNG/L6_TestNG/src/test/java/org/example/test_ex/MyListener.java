package org.example.test_ex;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Report instance creation");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Log result " + result.getName() + " success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Log fail");
        System.out.println("Log stack");
        System.out.println("Attach screenshot");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Start");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("End");
    }
}
