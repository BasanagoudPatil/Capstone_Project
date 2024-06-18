package com.CapstoneProject.CapstoneProject;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class register extends baseclass{
    @DataProvider(name = "registrationData")
    public Object[][] registrationData() throws IOException {
        String excelFilePath = "D://Wipro//Project//registration_data.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows();
        Object[][] data = new Object[rowCount - 1][sheet.getRow(0).getPhysicalNumberOfCells()];

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j] = cell.toString();
            }
        }
        workbook.close();
        inputStream.close();
        return data;
    }

    @Test(dataProvider = "registrationData")
    public void testRegistration(String userId, String newPassword, String confirmPassword, String firstName,
                                 String lastName, String email, String phone, String address1, String address2,
                                 String city, String state, String zip, String country, String languagePreference,
                                 String favouriteCategory) throws IOException {
        
        
        driver.findElement(By.xpath("//*[@id=\"MenuContent\"]/a[3]")).click();
       // driver.findElement(By.linkText("Register Now!")).click();

        driver.findElement(By.name("username")).sendKeys(userId);
        driver.findElement(By.name("password")).sendKeys(newPassword);
        driver.findElement(By.name("repeatedPassword")).sendKeys(confirmPassword);
        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys(phone);
        driver.findElement(By.name("address1")).sendKeys(address1);
        driver.findElement(By.name("address2")).sendKeys(address2);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("state")).sendKeys(state);
        driver.findElement(By.name("zip")).sendKeys(zip);
        driver.findElement(By.name("country")).sendKeys(country);

        WebElement languageSelect = driver.findElement(By.name("languagePreference"));
        languageSelect.sendKeys(languagePreference);

        WebElement categorySelect = driver.findElement(By.name("favouriteCategoryId"));
        categorySelect.sendKeys(favouriteCategory);

        WebElement myListCheckbox = driver.findElement(By.name("listOption"));
        if (!myListCheckbox.isSelected()) {
            myListCheckbox.click();
        }

        WebElement myBannerCheckbox = driver.findElement(By.name("bannerOption"));
        if (!myBannerCheckbox.isSelected()) {
            myBannerCheckbox.click();
        }

        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/div/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);
        saveButton.click();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        WebElement successMessage = driver.findElement(By.xpath("//p[contains(text(), 'Your account has been created.')]"));
        Assert.assertTrue(successMessage.isDisplayed(), "Registration failed!");
        takeScreenshot(userId);

      //  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      //  File destinationFile = new File("registration_result_" + userId + ".png");
      //  FileUtils.copyFile(screenshot, destinationFile);
    }
}
