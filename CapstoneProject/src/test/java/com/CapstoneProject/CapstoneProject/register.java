package com.CapstoneProject.CapstoneProject;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class register extends baseclass{
	@Test
	public void registerNewUser() throws Exception {
		String baseUrl="https://jpetstore.aspectran.com/"; 
		driver.get(baseUrl);
		
		driver.findElement(By.linkText("Sign In")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Register Now!']")).click();
		
		driver.findElement(By.name("username")).sendKeys("testusa");
		driver.findElement(By.name("password")).sendKeys("testusera@2");
		driver.findElement(By.name("repeatedPassword")).sendKeys("testusera@2");
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Ananthaa");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Reddyy");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testus32@gmail.com");
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("994992948");
		driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("TDOnnr23009");
		driver.findElement(By.cssSelector("input[name='address2']")).sendKeys("Near AMB");
		driver.findElement(By.name("city")).sendKeys("vizag");
		driver.findElement(By.name("state")).sendKeys("AndhraPradesh");
		driver.findElement(By.name("zip")).sendKeys("533499");
		driver.findElement(By.name("country")).sendKeys("India");
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//button[normalize-space()='Save Account Information']")).click();
		Thread.sleep(2000);
		String currentUrl=driver.getCurrentUrl();
		System.out.println(currentUrl);
		String actualUrl="https://jpetstore.aspectran.com/account/signonForm?created=true";
		System.out.println(actualUrl);
		if(currentUrl.equals(actualUrl)) {
			System.out.println("RegistrationTest passed");
		}
		else {
			System.out.println("Registration failed");
		}
	}

}
