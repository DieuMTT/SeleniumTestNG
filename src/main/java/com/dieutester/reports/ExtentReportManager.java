package com.dieutester.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/Extentreport/Extentreport.html");
        reporter.config().setReportName("Extent Report | Dieu Tester");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Selenium Java | Dieu Tester");
        extentReports.setSystemInfo("Author", "Anh Tester");
        return extentReports;
    }
}
