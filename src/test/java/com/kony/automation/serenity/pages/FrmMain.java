package com.kony.automation.serenity.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrmMain extends PageObject {

	@FindBy(id = "lblPostLogin")
	private WebElement lblPostLogin;

	@FindBy(name = "Go to frm1")
	public WebElement lbl_frm1;

	@FindBy(name = "Go to frm2")
	public WebElement lbl_frm2;

	@FindBy(name = "Go to frm3")
	public WebElement lbl_frm3;

	@FindBy(name = "Go to frm4")
	public WebElement lbl_frm4;

	@FindBy(name = "Go to frm5")
	public WebElement lbl_frm5;

	@FindBy(name = "Go to frmLogout")
	public WebElement lbl_frmLogout;

	public FrmMain(WebDriver driver) {
		super(driver);
	}

	public void goToFrm1() {
		this.lbl_frm1.click();
	}

	public boolean isDisplayed() {
		return (this.lblPostLogin.isDisplayed());
	}

	public void close() {
		this.getDriver().close();
	}
}
