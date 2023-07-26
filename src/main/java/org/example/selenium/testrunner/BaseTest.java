package org.example.selenium.testrunner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.example.selenium.util.BrowserFactory;
import org.example.selenium.util.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public abstract class BaseTest {
    protected WebDriver driver;

    @Parameters("browsername")
    @BeforeMethod
    public void openBrowser_openUrl(ITestContext context, @Optional("chrome") String brname) {
        this.driver = BrowserFactory.getBrowser(brname);
        BrowserFactory.openUrl(PropertiesFileReader.getPropValue("config", "orangehrm.url"));
    }


    public static ExtentReports extentReports;
    //
    @BeforeSuite
    public void initializeReport() {
        ExtentSparkReporter esr = new ExtentSparkReporter("orangehrm_reports/AllTestScriptResults.html");
//
        BaseTest.extentReports = new ExtentReports();
        BaseTest.extentReports.attachReporter(esr);
//        BaseTest.extentReports.setSystemInfo("OS", System.getProperty("os.name"));
//        BaseTest.extentReports.setSystemInfo("OS", System.getProperty("java.version"));
    }
    //
    @AfterSuite
    public void generateReport() {
        BaseTest.extentReports.flush();
        try {
            Desktop.getDesktop().browse(new File("orangehrm_reports/AllTestScriptResults.html").toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void closure() {
        BrowserFactory.closeAllWindows();
    }

}

