package com.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.pages.Loginpage;
import com.qa.utils.BaseClass;
import com.qa.utils.Config;

public class Logintest {

	WebDriver driver;
	Loginpage loginpage;

	@BeforeClass
	public void setup() {
		driver = BaseClass.initialization(Config.browser, Config.url);
		loginpage = PageFactory.initElements(driver, Loginpage.class);
	}

	@Test
	public void test() {
		loginpage.login(Config.adminuser, Config.adminpassword);

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
