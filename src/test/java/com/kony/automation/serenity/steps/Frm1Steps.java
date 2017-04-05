package com.kony.automation.serenity.steps;

import com.kony.automation.serenity.pages.Frm1;
import com.kony.automation.serenity.pages.FrmLogin;
import com.kony.automation.serenity.pages.FrmMain;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Frm1Steps {
    FrmLogin frmLogin;
    FrmMain frmMain;
    Frm1 frm1;
    Date date;
    String dateFormat = "yyyy-MM-dd";

    @Given("the user is on frm1 page")
    public void givenTheUserIsOnFrm1Page() {
        frmLogin.isDisplayed();
        frmLogin.clickBtnSignIn();
        frmMain.isDisplayed();
        frmMain.goToFrm1();
        frm1.isDisplayed();
    }

    @When("the user enters a date $date")
    public void whenTheUserEntersADate(String date) {
        SimpleDateFormat parser = new SimpleDateFormat(dateFormat);
        try {
            this.date = parser.parse(date);
        } catch (ParseException e) {
            throw new Error(e);
        }
        frm1.enterCalField(String.format(date, dateFormat));
    }

    @Then("they should see it chosen")
    public void thenTheySeeItChosen() {
        Assert.assertTrue("Date is not set", frm1.isDateEqualsTo(date));
        frmMain.close();
    }
}