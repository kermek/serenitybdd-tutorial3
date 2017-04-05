package com.kony.automation.serenity.steps;

import com.kony.automation.serenity.pages.FrmLogin;
import com.kony.automation.serenity.pages.FrmMain;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class LoginSteps {
    FrmLogin frmLogin;
    FrmMain frmMain;

    @Given("the user is on login page")
    public void givenTheUserIsOnLoginPage() {
        frmLogin.isDisplayed();
    }

    @When("the user enters login text $username")
    public void whenTheUserEntersLoginText(String username) {
        frmLogin.enterTextField1(username);
    }

    @When("the user enters password text $password")
    public void whenTheUserEntersPasswordText(String password) {
        frmLogin.enterTextField2(password);
    }

    @When("the user clicks login button")
    public void whenTheUserClicksLoginButton() {
        frmLogin.clickBtnSignIn();
    }

    @Then("they should be on main page")
    public void thenTheyShouldBeOnMainPage() {
        Assert.assertTrue("Main menu is not displayed", frmMain.isDisplayed());
        frmMain.close();
    }
}
