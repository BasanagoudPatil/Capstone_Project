package com.CapstoneProject.CapstoneProject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class baseclass {
WebDriver driver;
	
	@BeforeClass
	public void driver()
	{
		System.setProperty("webdriver.chrome.driver", "D:/Wipro/Project/driver/chromedriver-win64/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void close()
	{
		driver.quit();
	}


}
