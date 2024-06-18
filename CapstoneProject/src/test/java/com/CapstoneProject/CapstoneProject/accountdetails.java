package com.CapstoneProject.CapstoneProject;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class accountdetails extends baseclass {
	@Test
    public void testLoginAndViewAccountDetails() {
        // Navigate to the JPetStore demo website
        driver.get("https://jpetstore.aspectran.com/");
        takeScreenshot(driver, "JPetStore_HomePage");

        // Click on the "Sign In" link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        // Enter username and password
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[1]/input"));
        usernameField.clear();
        usernameField.sendKeys("Jpetstore");

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/label[2]/input"));
        passwordField.clear();
        passwordField.sendKeys("jpet@123");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/div/button"));
        loginButton.click();
        takeScreenshot(driver, "JPetStore_AfterLogin");

        // Navigate to the account details page
        WebElement myAccountLink = driver.findElement(By.linkText("My Account"));
        myAccountLink.click();
        takeScreenshot(driver, "JPetStore_AccountDetails");

        // Verify the account details page
        WebElement accountDetailsHeader = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(accountDetailsHeader.getText(), "User Information", "Account details page is not displayed as expected.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        // Create an instance of TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture screenshot as output type FILE
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Get the current date and time for unique screenshot names
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = dtf.format(now);

        // Set the destination path for the screenshot
        String dest = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png";

        // Copy the screenshot to the destination path
        try {
            FileHandler.copy(source, new File(dest));
            System.out.println("Screenshot taken: " + dest);
        } catch (IOException e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }

}
