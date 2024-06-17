package com.CapstoneProject.CapstoneProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class register extends baseclass{
	String baseUrl = "https://jpetstore.aspectran.com/";

	 @Test(priority = 1)
	    public void registerNewUser() throws Exception {
	        driver.get(baseUrl);

	        driver.findElement(By.linkText("Sign In")).click();

	        driver.findElement(By.xpath("//a[normalize-space()='Register Now!']")).click();

	        driver.findElement(By.name("username")).sendKeys("testusa2231");
	        driver.findElement(By.name("password")).sendKeys("testusera@221");
	        driver.findElement(By.name("repeatedPassword")).sendKeys("testusera@221");
	        driver.findElement(By.name("firstName")).sendKeys("Ananth");
	        driver.findElement(By.name("lastName")).sendKeys("Reddyyy");
	        driver.findElement(By.name("email")).sendKeys("testus325@gmail.com");
	        driver.findElement(By.name("phone")).sendKeys("9945623541");
	        driver.findElement(By.name("address1")).sendKeys("TDOnnr23009");
	        driver.findElement(By.name("address2")).sendKeys("Near AMB");
	        driver.findElement(By.name("city")).sendKeys("vizag");
	        driver.findElement(By.name("state")).sendKeys("AndhraPradesh");
	        driver.findElement(By.name("zip")).sendKeys("533499");
	        driver.findElement(By.name("country")).sendKeys("India");

	        Thread.sleep(4000);

	        driver.findElement(By.xpath("//button[normalize-space()='Save Account Information']")).click();
	        Thread.sleep(2000);
	        String currentUrl = driver.getCurrentUrl();
	        System.out.println(currentUrl);
	        String actualUrl = "https://jpetstore.aspectran.com/account/signonForm?created=true";
	        System.out.println(actualUrl);
	        if (currentUrl.equals(actualUrl)) {
	            System.out.println("RegistrationTest passed");
	        } else {
	            System.out.println("Registration failed");
	        }
	    }

	    @AfterClass
	    public void close1() throws InterruptedException {
	        Thread.sleep(5000);
	        driver.quit();
	    }

	    @Test(priority = 2)
	    public void invalidRegistration() throws InterruptedException {
	        driver.get(baseUrl);

	        driver.findElement(By.linkText("Sign In")).click();
	        driver.findElement(By.xpath("//a[normalize-space()='Register Now!']")).click();

	        // Enter existing username to simulate invalid registration
	        driver.findElement(By.name("username")).sendKeys("existinguser");
	        driver.findElement(By.name("password")).sendKeys("testpassword");
	        driver.findElement(By.name("repeatedPassword")).sendKeys("testpassword");
	        driver.findElement(By.name("firstName")).sendKeys("John");
	        driver.findElement(By.name("lastName")).sendKeys("Doe");
	        driver.findElement(By.name("email")).sendKeys("john.doe@example.com");
	        driver.findElement(By.name("phone")).sendKeys("1234567ew");
	        driver.findElement(By.name("address1")).sendKeys("123 Street");
	        driver.findElement(By.name("city")).sendKeys("New York");
	        driver.findElement(By.name("state")).sendKeys("NY");
	        driver.findElement(By.name("zip")).sendKeys("10001");
	        driver.findElement(By.name("country")).sendKeys("India");

	        Thread.sleep(4000);

	        driver.findElement(By.xpath("//button[normalize-space()='Save Account Information']")).click();
	        Thread.sleep(2000);

	        // Explicit wait for error message to be visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        try {
	            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.messages li")));
	            assert errorMessage.getText().contains("An account already exists with the same username.");
	            System.out.println("Invalid Registration test passed.");
	        } catch (Exception e) {
	            System.out.println("Invalid Registration test failed. Error message not found.");
	            // Optionally, takeScreenshot() or log the exception
	        }
	    }

}
