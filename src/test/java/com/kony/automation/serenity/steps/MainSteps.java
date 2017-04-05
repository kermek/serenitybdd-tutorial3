package com.kony.automation.serenity.steps;

import com.kony.automation.serenity.pages.Frm1;
import com.kony.automation.serenity.pages.FrmLogin;
import com.kony.automation.serenity.pages.FrmMain;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class MainSteps {
    FrmLogin frmLogin;
    FrmMain frmMain;
    Frm1 frm1;

    @Given("the user is logged in")
    public void givenTheUserIsOnMainPage() {
        frmLogin.isDisplayed();
        frmLogin.clickBtnSignIn();
        frmMain.isDisplayed();
    }

    @When("the user clicks Go to frm1")
    public void whenTheUserClicksGoToFrm1() {
       frmMain.goToFrm1();
    }

    @Then("they should be on frm1 page")
    public void thenTheyShouldBeOnFrm1Page() {
        Assert.assertTrue("Frm1 is not displayed", frm1.isDisplayed());
        frmMain.close();
    }
}
