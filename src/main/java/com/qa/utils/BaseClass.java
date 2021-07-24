package com.qa.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.pages.Homepage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static EventFiringWebDriver efdriver;
	

	public static WebDriver initialization(String browser, String Url) {

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		efdriver = new EventFiringWebDriver(driver);
		Listeners listen = new Listeners();
		efdriver.register(listen);

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

	public static void takeScreenshotAtEndOfTest(String filename) throws IOException {

		TakesScreenshot screenshot = ((TakesScreenshot) BaseClass.driver);
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(
				System.getProperty("user.dir") + "\\Screenshots\\" + System.currentTimeMillis() + filename + ".png");
		FileUtils.copyFile(source, dest);

	}

}
