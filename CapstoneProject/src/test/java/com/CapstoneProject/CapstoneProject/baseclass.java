package com.CapstoneProject.CapstoneProject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class baseclass {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setup() {
        ExtentSparkReporter spark=new ExtentSparkReporter("./extent-reports/extent-report.html");
        extent=new ExtentReports();
        extent.attachReporter(spark);

        System.setProperty("webdriver.chrome.driver", "D:/Wipro/Project/driver/chromedriver-win64/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
    }
    
    @BeforeMethod
    public void beforeMethod() 
    {
        test=extent.createTest("Test Case: "+this.getClass().getName());
    }

    @AfterMethod
    public void afterMethod() 
    {
        extent.flush();
    }

    @AfterClass
    public void close() {
        driver.quit();
        extent.flush();
    }
}
