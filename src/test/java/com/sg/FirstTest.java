package com.sg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class FirstTest {
	ChromeOptions co = new ChromeOptions();
	WebDriver wd = new ChromeDriver(co);
	
  @BeforeClass
  public void testSetup() {
	  System.setProperty("webdriver.chrome.driver", "C:\\\\chromedriver\\\\chromedriver.exe");
  }
  
  @BeforeMethod
  public void openBrowser() {
	  wd.get("http://localhost:8080/addressbook/");
	  wd.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  wd.findElement(By.className("v-button")).click();
	  Reporter.log("Details are Entered");
  }
  
  
  @Test(description="This method validates the New Contact")
  public void contactDetails() throws InterruptedException {
	  	wd.findElement(By.className("v-button")).click();
		wd.findElement(By.id("gwt-uid-5")).sendKeys("Niladri Sankar");
		wd.findElement(By.id("gwt-uid-7")).sendKeys("Mondal");
		wd.findElement(By.id("gwt-uid-9")).sendKeys("9999999999");
		wd.findElement(By.id("gwt-uid-11")).sendKeys("nil@gmail.com");
		wd.findElement(By.id("gwt-uid-13")).sendKeys("6/6/23,");
		Reporter.log("Details are Entered");
		Thread.sleep(2000);
  }
  

  @AfterMethod
  public void saveContact() throws InterruptedException {
	  wd.findElement(By.className("v-button-primary")).click();
	  Thread.sleep(2000);
  }

  

  @AfterClass
  public void afterClass() {
	  wd.quit();
  }

}
