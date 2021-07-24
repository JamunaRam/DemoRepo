package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.BaseClass;

public class Homepage extends BaseClass {
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[text() ='New Customer']")
	WebElement newcustomerbtn;
	
	@FindBy(name = "name")
	WebElement customername;

	@FindBy(xpath = "//input[@name='rad1'][2]")
	WebElement sex;

	@FindBy(id = "dob")
	WebElement DOB;

	@FindBy(name = "addr")
	WebElement address;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(name = "pinno")
	WebElement pin;

	@FindBy(name = "telephoneno")
	WebElement tele;

	@FindBy(name = "emailid")
	WebElement emailid;

	@FindBy(name = "sub")
	WebElement submit;

	public void newCustomer() {
		
		newcustomerbtn.click();

		BaseClass.waitV_C(customername).sendKeys("Jamuna1712");
		BaseClass.waitV_C(sex).click();
		BaseClass.waitE_C(DOB).sendKeys("06-09-1990");
		BaseClass.waitV_C(address).sendKeys("89, 10th Cross, 1 st main Jagadish nagar, Bangalore");
		BaseClass.waitV_C(city).sendKeys("Bangalore");
		BaseClass.waitE_C(state).sendKeys("Karnataka");
		BaseClass.waitV_C(pin).sendKeys("560075");
		BaseClass.waitV_C(tele).sendKeys("9812345678");
		BaseClass.waitE_C(emailid).sendKeys("jamuan123@gmail.com");
		BaseClass.waitE_C(submit).click();
	}

}
