package com.CapstoneProject.CapstoneProject;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

public class login extends baseclass{
	@Test
    public void testLogin() throws InterruptedException, IOException {
        // Open the login page
    	
        driver.get("https://jpetstore.aspectran.com/");
        
        //Click on the Sign in button
        
        WebElement signin = driver.findElement(By.cssSelector("a[href='/account/signonForm']"));
        signin.click();
        Thread.sleep(2000);

        // Find the username and password input fields
        
       WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
       WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));

        // Enter login credentials
        usernameField.clear();
        passwordField.clear();
        
        usernameField.sendKeys("Jpetstore");
        passwordField.sendKeys("jpet@123");
        
        // Find and click the login button
        
       WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
       loginButton.click();
       Thread.sleep(2000);
       takeScreenshot("validdetails");
       WebElement Signout = driver.findElement(By.xpath("//a[normalize-space()='Sign Out']"));
       Signout.click();
       Thread.sleep(2000);

          
}
	@Test
    public void Invalidpassword() throws InterruptedException, IOException {
        // Open the login page
        driver.get("https://jpetstore.aspectran.com/");

        // Click on the Sign in button
        WebElement signin = driver.findElement(By.cssSelector("a[href='/account/signonForm']"));
        signin.click();
        Thread.sleep(2000);

        // Find the username and password input fields
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));

        // Enter invalid login credentials
        usernameField.clear();
        passwordField.clear();

        usernameField.sendKeys("Jpetstoree");
        passwordField.sendKeys("invalid");

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 350)");
		
        Thread.sleep(2000);
        takeScreenshot("invalidpassword");
        
        // Verify the login failed by checking for an error message or remaining on the same page
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='panel failed']")); 
        Assert.assertTrue(errorMessage.isDisplayed(), "Invalid username or password. Signon failed.");
        Thread.sleep(4000);
    
 
 }
	@Test
    public void invalidusername() throws InterruptedException, IOException {
        // Open the login page
        driver.get("https://jpetstore.aspectran.com/");

        // Click on the Sign in button
        WebElement signin = driver.findElement(By.cssSelector("a[href='/account/signonForm']"));
        signin.click();
        Thread.sleep(2000);

        // Find the username and password input fields
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));

        // Enter invalid login credentials
        usernameField.clear();
        passwordField.clear();

        usernameField.sendKeys("invalid");
        passwordField.sendKeys("jpet@123");

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 350)");
		
        Thread.sleep(2000);
        takeScreenshot("invalidusername");
       
        // Verify the login failed by checking for an error message or remaining on the same page
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='panel failed']")); 
        Assert.assertTrue(errorMessage.isDisplayed(), "Invalid username or password. Signon failed.");
        Thread.sleep(4000);
   
 }
	@Test
    public void emptyusername() throws InterruptedException, IOException {
        // Open the login page
        driver.get("https://jpetstore.aspectran.com/");

        // Click on the Sign in button
        WebElement signin = driver.findElement(By.cssSelector("a[href='/account/signonForm']"));
        signin.click();
        Thread.sleep(2000);

        // Find the username and password input fields
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));

        // Enter invalid login credentials
        usernameField.clear();
        passwordField.clear();

        usernameField.sendKeys("");
        passwordField.sendKeys("jpet@123");

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 350)");
		
        Thread.sleep(2000);
        takeScreenshot("emptyusername");
       
        // Verify the login failed by checking for an error message or remaining on the same page
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='panel failed']")); 
        Assert.assertTrue(errorMessage.isDisplayed(), "Invalid username or password. Signon failed.");
        Thread.sleep(4000);
    
 
 }
	@Test
    public void emptypassword() throws InterruptedException, IOException {
        // Open the login page
        driver.get("https://jpetstore.aspectran.com/");

        // Click on the Sign in button
        WebElement signin = driver.findElement(By.cssSelector("a[href='/account/signonForm']"));
        signin.click();
        Thread.sleep(2000);

        // Find the username and password input fields
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));

        // Enter invalid login credentials
        usernameField.clear();
        passwordField.clear();

        usernameField.sendKeys("Jpetstoree");
        passwordField.sendKeys("");

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 350)");
		
        Thread.sleep(2000);
        takeScreenshot("emptypassword");
        // Verify the login failed by checking for an error message or remaining on the same page
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='panel failed']")); 
        Assert.assertTrue(errorMessage.isDisplayed(), "Invalid username or password. Signon failed.");
        Thread.sleep(4000);

 }
	
}


