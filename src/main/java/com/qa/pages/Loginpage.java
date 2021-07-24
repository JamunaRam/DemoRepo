package com.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.BaseClass;

public class Loginpage extends BaseClass {

	static Logger log = Logger.getLogger(Loginpage.class);
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement uname;

	@FindBy(name = "password")
	WebElement pwd;

	@FindBy(name = "btnLogin")
	WebElement login;

	public void login(String username, String password) {
		log.info("Entered a valid Username");
		BaseClass.waitV_C(uname).sendKeys(username);
		log.info("Entered a valid Password");
		BaseClass.waitV_C(pwd).sendKeys(password);
		log.info("Click on Login Button");
		BaseClass.waitE_C(login).click();

	}
}