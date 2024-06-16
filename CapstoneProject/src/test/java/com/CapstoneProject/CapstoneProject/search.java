package com.CapstoneProject.CapstoneProject;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import org.testng.Assert;

public class search extends baseclass{
	@Test(priority=0)
    public void findsearchbox() throws InterruptedException, IOException {
        driver.get("https://jpetstore.aspectran.com/");
        // Your test code here
        WebElement searchbox=driver.findElement(By.xpath("//*[@id=\"SearchContent\"]/form/div/input"));
        File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot,new File("./screenshots/searchbox.png"));

        Thread.sleep(2000);
    }
	
	@Test(priority=1)
	public void sendkeys() throws InterruptedException, IOException
	{
	 String item="Dog";
     driver.get("https://jpetstore.aspectran.com/");
     WebElement searchbox=driver.findElement(By.xpath("//*[@id=\"SearchContent\"]/form/div/input"));
     searchbox.sendKeys(item);
     File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
     FileHandler.copy(screenshot,new File("./screenshots/sendkeys.png"));

     Thread.sleep(2000);
	}
	@Test(priority=2)
	public void search() throws InterruptedException, IOException
	{
		driver.get("https://jpetstore.aspectran.com/");
	     WebElement searchbox=driver.findElement(By.xpath("//*[@id=\"SearchContent\"]/form/div/input"));
	     searchbox.sendKeys("Fish");
	     WebElement search=driver.findElement(By.cssSelector("#SearchContent > form > div > div > button"));
	     search.click();
	     WebElement tableBody=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody"));

	        List<WebElement> rows=tableBody.findElements(By.tagName("tr"));

	        boolean hasDataRows=false;
	        for (WebElement row : rows) {
	            List<WebElement> cells=row.findElements(By.tagName("td"));
	            if (cells.size()>0) {
	                hasDataRows=true;
	                break;
	            }
	        }
	        File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileHandler.copy(screenshot,new File("./screenshots/search.png"));

	        // Assert that no data rows are present
	        Assert.assertTrue(hasDataRows, "results not found");
	        
	}
	@Test(priority=3)
	public void validsearch() throws IOException {
		String item="goldfish";
		WebElement searchbox=driver.findElement(By.xpath("//*[@id=\"SearchContent\"]/form/div/input"));
	     searchbox.sendKeys(item);
	     searchbox.submit();
        // Verify the search results
        WebElement result = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[2]"));
        File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot,new File("./screenshots/validsearch.png"));

        Assert.assertTrue(result.getText().toLowerCase().contains(item), "Search result failed to get valid result");
        

    }
	
	@Test(priority=4)
	public void emptysearch() throws InterruptedException, IOException
	{
		WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"SearchContent\"]/form/div/input"));
        searchbox.clear();
        searchbox.submit();
        Thread.sleep(2000);

        WebElement tableBody=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody"));

        List<WebElement> rows=tableBody.findElements(By.tagName("tr"));

        boolean hasDataRows=false;
        for (WebElement row : rows) {
            List<WebElement> cells=row.findElements(By.tagName("td"));
            if (cells.size()>0) {
                hasDataRows=true;
                break;
            }
        }
        File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot,new File("./screenshots/emptysearch.png"));

        // Assert that no data rows are present
        Assert.assertFalse(hasDataRows, "result found");
	}
	
	@Test(priority=5)
	public void invalidsearch() throws IOException
	{
		String item="Invalid search";
		WebElement searchbox=driver.findElement(By.xpath("//*[@id=\"SearchContent\"]/form/div/input"));
	     searchbox.sendKeys(item);
	     searchbox.submit();
        // Verify the search results
	     WebElement tableBody=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody"));

	        List<WebElement> rows=tableBody.findElements(By.tagName("tr"));

	        boolean hasDataRows=false;
	        for (WebElement row : rows) {
	            List<WebElement> cells=row.findElements(By.tagName("td"));
	            if (cells.size()>0) {
	                hasDataRows=true;
	                break;
	            }
	        }
	        File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileHandler.copy(screenshot,new File("./screenshots/invalidsearch.png"));


	        // Assert that no data rows are present
	        Assert.assertFalse(hasDataRows, "Result Found");
	}
         
}
	
	

