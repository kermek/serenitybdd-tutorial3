package com.kony.automation.serenity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Date;

public class Frm1 extends BasePage {

	@FindBy(id = "frm1")
	private WebElement frm1;

	@FindBy(id = "cal")
	private WebElement cal;

	public Frm1(WebDriver driver) {
		super(driver);
	}

	public void enterCalField(String date) {
		setDatePicker(cal, date);
	}

	public boolean isDisplayed() {
		return this.cal.isDisplayed();
	}

	public boolean isDateEqualsTo(Date date) {
		return checkDatePickerValue(cal, date);
	}

}
