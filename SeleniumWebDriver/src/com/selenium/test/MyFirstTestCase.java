package com.selenium.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyFirstTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//firefox driver path
		//System.setProperty("webdriver.firefox.marionette", "D://Java//geckodriver-v0.32.2-win-aarch64//geckodriver");
		//Edge
		System.setProperty("webdriver.edge.driver", "D://Java//edgedriver_win64//msedgedriver.exe");

		
		
		//invoke firefox browser
		//FirefoxDriver firefoxDriver = new FirefoxDriver();
		//alternative through interface
		//WebDriver webDriver = new FirefoxDriver();
		WebDriver webDriver = new EdgeDriver();
		//String title = webDriver.getTitle();
				
		webDriver.get("https://trustworks-test03.stretto.com/#/auth/login"); 	//open URL
		
		Duration duration =  Duration.ofSeconds(10);
		
		//Wait for element to be ready
		WebElement loginTextBox = new WebDriverWait(webDriver, duration)
		        .until(ExpectedConditions.elementToBeClickable(By.name("email")));

		WebElement passTextBox = new WebDriverWait(webDriver, duration)
		        .until(ExpectedConditions.elementToBeClickable(By.name("password")));

		WebElement loginButton = new WebDriverWait(webDriver, duration)
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div[1]/form/div[3]/div/button")));

		webDriver.manage().window().maximize();//maximize the window
		
		loginTextBox.sendKeys("employee1@stretto.com");
		passTextBox.sendKeys("ABCdef123!@#");
		loginButton.click();
		
	//	WebElement button1 = fireFoxDriver.findElement(By.id("loginBtn"));
		
		//String value = button1.get
		//System.out.println("Button Text: " + value);
		
		
		
		//fireFoxDriver.quit();
		//webDriver.close();
		
		//fireFoxDriver.findElement(By.name("passwd")).sendKeys("Hareem123$");
		
		
		//chrome
		
		//Edge
		
		//safari
	}

}
