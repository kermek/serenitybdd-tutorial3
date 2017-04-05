package com.kony.automation.serenity.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.util.concurrent.TimeUnit.SECONDS;

public class FrmLogin extends PageObject {

	@FindBy(id = "lblsignin")
	private WebElement lbl_SignIn;

	@FindBy(id = "TextField1")
	private WebElement textField1;

	@FindBy(id = "TextField2")
	private WebElement textField2;

	@FindBy(id = "btnSignIn")
	public WebElement btnSignIn;


	public FrmLogin(WebDriver driver) {
		super(driver);
		setImplicitTimeout(5, SECONDS);
	}

	public void enterTextField1(String user) {
		textField1.sendKeys(user + Keys.ENTER);
	}

	public void enterTextField2(String password) {
		textField2.sendKeys(password + Keys.ENTER);
	}

	public void clickBtnSignIn() {
		btnSignIn.click();
	}

	public boolean isDisplayed() {
		return this.btnSignIn.isDisplayed();
	}
}
