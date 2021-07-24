package com.qa.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.pages.Homepage;
import com.qa.pages.Loginpage;
import com.qa.utils.BaseClass;
import com.qa.utils.Config;

public class HomepageTest {

	WebDriver driver;
	Homepage home;
	Loginpage login;
	
	@BeforeClass
	public void setup() {
		driver = BaseClass.initialization(Config.browser, Config.url);
		login = new Loginpage();
		home = new Homepage();
	}

	@Test
	public void loginTest() {
		login.login(Config.adminuser, Config.adminpassword);
	}

	@Test
	public void newCustomerCreationTest() {
		home.newCustomer();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
