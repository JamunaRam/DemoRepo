package com.qa.pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.BaseClass;

public class Homepage extends BaseClass {

	static Logger log = Logger.getLogger(Homepage.class);
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
		PropertyConfigurator.configure("log4j.properties.txt");

		log.info("Click on New Customername tab : ");
		newcustomerbtn.click();
		log.info("Enter the customer name : ");
		BaseClass.waitV_C(customername).sendKeys("Jamuna1712");
		log.info("Enter the customer sex : ");
		BaseClass.waitV_C(sex).click();
		log.info("Enter the customer DOB : ");
		BaseClass.waitE_C(DOB).sendKeys("06-09-1990");
		log.info("Enter the customer address : ");
		BaseClass.waitV_C(address).sendKeys("89, 10th Cross, 1 st main Jagadish nagar, Bangalore");
		log.info("Enter the customer city : ");
		BaseClass.waitV_C(city).sendKeys("Bangalore");
		log.info("Enter the customer state : ");
		BaseClass.waitE_C(state).sendKeys("Karnataka");
		log.info("Enter the customer pincode : ");
		BaseClass.waitV_C(pin).sendKeys("560075");
		log.info("Enter the customer telephone number : ");
		BaseClass.waitV_C(tele).sendKeys("9812345678");
		log.info("Enter the customer email id : ");
		BaseClass.waitE_C(emailid).sendKeys("jamuan123@gmail.com");
		log.info("Click on submit button");
		BaseClass.waitE_C(submit).click();
	}

}
