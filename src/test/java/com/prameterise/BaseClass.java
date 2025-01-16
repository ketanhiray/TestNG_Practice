package com.prameterise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	WebDriver driver;
    
	public BaseClass(WebDriver driver) {
		// TODO Auto-generated method stub
		this.driver = driver;
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

		 driver=new ChromeDriver();

	}

}
