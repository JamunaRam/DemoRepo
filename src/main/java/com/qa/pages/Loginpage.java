package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.utils.BaseClass;

public class Loginpage {

	@FindBy(name = "uid")
	WebElement uname;

	@FindBy(name = "password")
	WebElement pwd;

	@FindBy(name = "btnLogin")
	WebElement login;

	public void login(String username, String password) {

		BaseClass.waitV_C(uname).sendKeys(username);
		BaseClass.waitV_C(pwd).sendKeys(password);
		BaseClass.waitE_C(login).click();

	}
} 