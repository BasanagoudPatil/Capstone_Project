package com.CapstoneProject.CapstoneProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class search extends baseclass{
	@Test(priority=0)
    public void findsearchbox() throws InterruptedException {
        driver.get("https://jpetstore.aspectran.com/");
        // Your test code here
        WebElement searchbox=driver.findElement(By.xpath("//*[@id=\"SearchContent\"]/form/div/input"));
        Thread.sleep(2000);
    }
	@Test(priority=1)
	public void sendkeys() throws InterruptedException
	{
     driver.get("https://jpetstore.aspectran.com/");
     WebElement searchbox=driver.findElement(By.xpath("//*[@id=\"SearchContent\"]/form/div/input"));
     searchbox.sendKeys("Dog");
     Thread.sleep(2000);
	}
	@Test(priority=2)
	public void search() throws InterruptedException
	{
		driver.get("https://jpetstore.aspectran.com/");
	     WebElement searchbox=driver.findElement(By.xpath("//*[@id=\"SearchContent\"]/form/div/input"));
	     searchbox.sendKeys("Fish");
	     searchbox.submit();
	     Thread.sleep(2000);
	}
	@Test(priority=3)
	public void validsearch() {
		String item="goldfish";
		WebElement searchbox=driver.findElement(By.xpath("//*[@id=\"SearchContent\"]/form/div/input"));
	     searchbox.sendKeys(item);
	     searchbox.submit();
        // Verify the search results
        WebElement result = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[2]"));
        Assert.assertTrue(result.getText().toLowerCase().contains(item));
        

    }
	
	@Test(priority=4)
	public void emptysearch()
	{
        String empty="";
		WebElement searchbox=driver.findElement(By.xpath("//*[@id=\"SearchContent\"]/form/div/input"));
	    searchbox.sendKeys(empty);
	    searchbox.submit();
	    WebElement table = driver.findElement(By.xpath("//div[@id='Catalog']/table"));

        // Get all rows of the table (excluding headers)
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        // Assert that there are no rows in the table (indicating empty results)
      //  Assert.assertTrue(rows.isEmpty());
        //System.out.println(rows.size()<1);
        Assert.assertTrue(rows.size()==0);

       // Assert.assertFalse(rows.isEmpty());

	}
         
}
	
	

