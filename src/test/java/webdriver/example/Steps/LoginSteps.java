package webdriver.example.Steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import webdriver.example.WebdriverHelper;
import webdriver.example.pages.LoginPage;

/**
 * Created by suci on 04/02/2018.
 */
public class LoginSteps {
    private LoginPage loginPage;

    @Given("^I am in login page$")
    public void iAmInLoginPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage = new LoginPage(WebdriverHelper.driver);
        loginPage.open();
    }

    @When("^I input correct email: \"([^\"]*)\"$")
    public void iInputCorrectEmail(String email) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.typeEmail(email);
    }

    @And("^I input correct password : \"([^\"]*)\"$")
    public void iInputCorrectPassword(String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.typePassword(password);
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickLoginButton();
    }

    @Then("^I logged in$")
    public void iLoggedIn() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.verifyLoginSuccess();
    }
}
