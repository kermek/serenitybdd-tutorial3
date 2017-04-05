package com.kony.automation.serenity.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Frm1 extends PageObject {

	@FindBy(id = "frm1")
	private WebElement frm1;

	@FindBy(id = "cal")
	private WebElement cal;

	@FindBy(name = "Cancel")
	private WebElement cancel;

	public Frm1(WebDriver driver) {
		super(driver);
	}

	public void enterCalField(String date) {
		Date dt;
		try {
			dt = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			throw new Error(e);
		}
		String[] dateFormated  = new SimpleDateFormat("MMMM dd yyyy").format(dt).split(" ");
		cal.click();
		List<WebElement> pickerWheels = this.getDriver().findElements(By.xpath("//XCUIElementTypePickerWheel"));
		pickerWheels.get(0).sendKeys(dateFormated[0]);
		pickerWheels.get(1).sendKeys(dateFormated[1].replaceFirst("^0+(?!$)", ""));
		pickerWheels.get(2).sendKeys(dateFormated[2]);
		cancel.click();
	}

	public boolean isDisplayed() {
		return this.cal.isDisplayed();
	}

	public boolean isDateEqualsTo(Date date) {
		return this.cal.getText().equals(new SimpleDateFormat("dd/MM/yyyy").format(date));
	}
}
