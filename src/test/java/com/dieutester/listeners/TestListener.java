package com.dieutester.listeners;

import com.aventstack.extentreports.Status;
import com.dieutester.helpers.CaptureHelper;
import com.dieutester.helpers.PropertiesHelper;
import com.dieutester.reports.ExtentReportManager;
import com.dieutester.reports.ExtentTestManager;
import com.dieutester.utils.LogUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }
@Override
    public void onStart(ITestContext result) {
        PropertiesHelper.loadAllFiles();
        LogUtils.info("onStart");
    }

    @Override
    public void onFinish(ITestContext result) {
        LogUtils.info("onFinish ");

        //Kết thúc và thực thi Extents Report
        ExtentReportManager.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
//        LogUtils.info("onTestStart: " + result.getName());
        LogUtils.info(" ");
        LogUtils.info("******* " + result.getName()+"*******");
        CaptureHelper.startRecord(result.getName());

        //Bắt đầu ghi 1 TCs mới vào Extent Report
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("==>" + result.getName()+" is successfully.");
//        CaptureHelper.takeScreenshot(result.getName());

        CaptureHelper.stopRecord();

        //Extent Report
        ExtentTestManager.addScreenShot(result.getName());
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " is passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.error("==> " + result.getName()+"is FAIL.");
        CaptureHelper.takeScreenshot(result.getName());

        CaptureHelper.stopRecord();

        //Extent Report
        ExtentTestManager.addScreenShot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
//        LogUtils.warn("onTestSkipped: " + result.getName());
          LogUtils.warn("********" + result.getName()+"is SKIPPED********");

        CaptureHelper.stopRecord();

        //Extent Report
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        LogUtils.info("onTestFailedButWithinSuccessPercentage: " + result.getName());
    }
}
