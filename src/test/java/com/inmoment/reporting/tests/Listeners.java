package com.inmoment.reporting.tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " Test case started.");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("The name of the test successfully run is: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("The name of the test failed is: " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("The name of the test skipped is: " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(result.getName() + " Test case failed but within the success percentage");
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println(result.getName() + " Test case is failed with timeout");
    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
