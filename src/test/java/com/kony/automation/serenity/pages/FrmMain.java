package com.kony.automation.serenity.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrmMain extends PageObject {

	@FindBy(id = "lblPostLogin")
	private WebElement lblPostLogin;

	@FindBy(id = "btnGoToFrm1")
	public WebElement lbl_frm1;

	@FindBy(id = "btnGoToFrm2")
	public WebElement lbl_frm2;

	@FindBy(id = "btnGoToFrm3")
	public WebElement lbl_frm3;

	@FindBy(id = "btnGoToFrm4")
	public WebElement lbl_frm4;

	@FindBy(id = "btnGoToFrm5")
	public WebElement lbl_frm5;

	@FindBy(id = "btnGoToFrmLogout")
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
		this.getDriver().quit();
	}
}
