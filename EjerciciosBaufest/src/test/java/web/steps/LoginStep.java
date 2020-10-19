package web.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import web.driver.BaseDriver;
import web.pages.LoginPage;
import web.utilities.ControlUserInterface;

public class LoginStep extends BaseDriver {

    ControlUserInterface cui = new ControlUserInterface();
    LoginPage loginPage = new LoginPage(driver);

    @Given("I enter the web {string}")
    public void i_enter_the_web(String url) {
        cui.go_url(url);
    }

    @Given("I chose the option {string}")
    public void chose_the_option(String option) {
        loginPage.choose_menu_option(option);
    }

    @Given("I set the username {string} and password {string}")
    public void set_the_username_and_password(String username, String password) {
        loginPage.set_user_and_password_for_sign_up(username, password);
    }

    @When("I click the button {string}")
    public void iClickTheButton(String buttonName) {
        loginPage.click_button(buttonName);
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String succesfullyMessage) {
        Assert.assertEquals("We verify succesfull message", succesfullyMessage, loginPage.getMessage());
    }

    @Then("I should see the menu option {string}")
    public void iShouldSeeMyUsername(String menuOption) {
        Assert.assertEquals("We verify option", menuOption, loginPage.getOptionName(menuOption));
    }

    @And("set the user {string} and pass {string}")
    public void setTheUserUsernameAndPassPassword(String user, String pass) {
        loginPage.set_user_and_password_for_log_in(user, pass);
    }

    @And("I am already log in")
    public void userIsAlreadyLogIn() {
        var actionValue = "Log in";
        var userName = "admin100";
        var password = "admin100";

        cui.go_url("https://www.demoblaze.com/");
        loginPage.log_in_user(actionValue, userName, password, actionValue);
    }
}
