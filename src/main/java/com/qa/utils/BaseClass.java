package com.qa.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;

	public static WebDriver initialization(String browser, String Url) {

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(Config.implicitwait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Config.pageloadTimeout, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		return driver;
	}

	public static WebElement waitE_C(WebElement element) {
		wait = new WebDriverWait(driver, Config.waitElement_Clickable);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitV_C(WebElement element) {
		wait = new WebDriverWait(driver, Config.waitEelement_Visible);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

}
