package com.CapstoneProject.CapstoneProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class login extends baseclass{
	@Test
    public void testLogin() throws InterruptedException {
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
          
  }
}
