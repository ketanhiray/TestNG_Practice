package com.prameterise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PrameterDemo {

	WebDriver driver;

	@BeforeSuite
	public void setup() {

		// this.driver = driver;
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Parameters({ "url" })
	@Test(priority = 1)
	public void login(String url) {

		driver.get(url);

	}

	@DataProvider(name = "loginDetails")
	public Object[][] getDataFromProvider() {
		return new Object[][] { { "ketan", "123" } };

	}

	@Test(dataProvider = "loginDetails", priority = 2)
	public void UserDetails(String uname, String pwd) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys(uname);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(pwd);

	}

	@Test(groups = { "sanity" })
	public void grouptest() {
		System.out.println("This is menthod 1 Grouping test");

	}

	@Test(groups = { "sanity" }, enabled = false)
	public void grouptest1() {
		System.out.println("This is menthod 2 Grouping test");

	}

	@Test(groups = { "sanity" },invocationCount=3)
	public void grouptest3() {
		System.out.println("This is menthod 3 Grouping test");

	}
	@Test(groups = { "sanity" },dependsOnMethods= {"grouptest3"})
	public void grouptest31() {
		System.out.println("This is menthod 31 Grouping test");

	}

	@Test(groups = { "Regrassion" })
	public void grouptest4() {
		System.out.println("This is menthod 4 Regrassion test");

	}

	@Test(groups = { "Regrassion" })
	public void grouptest5() {
		System.out.println("This is menthod 5 Regrassion test");

	}
	
	@Test(groups= {"sanity"},timeOut=2000)
	public void timeoutdemo() {
		
	System.out.println("Time out Time out");
		
	}
	

}
