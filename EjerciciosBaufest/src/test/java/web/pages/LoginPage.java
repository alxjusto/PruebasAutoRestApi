package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.utilities.ControlUserInterface;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    ControlUserInterface cui = new ControlUserInterface();

    private By menuOption = By.xpath("//a[text()='%s']");
    private By signUpButton = By.xpath("//button[text()='%s']");
    private By nameOfUserOption = By.xpath("//a[@id='nameofuser' and text()='Welcome %s']");



    @FindBy(xpath = "//input[@id='sign-username']")
    private WebElement usernameSignUpField;

    @FindBy(xpath = "//input[@id='sign-password']")
    private WebElement passwordSignUpField;

    @FindBy(xpath = "//input[@id='loginusername']")
    private WebElement userSignInField;

    @FindBy(xpath = "//input[@id='loginpassword']")
    private WebElement passSignInField;

    public void choose_menu_option(String option) {
        By updateElement = cui.updateXpath(menuOption, option);
        cui.waitForElement(updateElement);
        driver.findElement(updateElement).click();
    }

    public void set_user_and_password_for_sign_up(String username, String password) {
        cui.isPresent(usernameSignUpField);
        usernameSignUpField.sendKeys(username);
        passwordSignUpField.sendKeys(password);
    }

    public void click_button(String buttonName) {
        By updateElement = cui.updateXpath(signUpButton, buttonName);
        cui.waitForElement(updateElement);
        driver.findElement(updateElement).click();
    }

    public String getMessage() {
        String message;
        cui.changeToAlert();
        message = cui.getTextFromAlert();
        cui.acceptAlert();

        return message;
    }

    public void set_user_and_password_for_log_in(String user, String pass) {
        cui.isPresent(userSignInField);
        userSignInField.sendKeys(user);
        passSignInField.sendKeys(pass);
    }

    public void log_in_user(String menuOption, String user, String pass, String buttonName) {
        choose_menu_option(menuOption);
        set_user_and_password_for_log_in(user, pass);
        click_button(buttonName);
        waitForLoggedUser(user);
    }

    private void waitForLoggedUser(String user) {
        By updateElement = cui.updateXpath(this.nameOfUserOption, user);
        cui.waitForElement(updateElement);
    }

    public String getOptionName(String menuOption) {
        By updateElement = cui.updateXpath(this.menuOption, menuOption);
        cui.waitForElement(updateElement);
        return driver.findElement(updateElement).getText();
    }
}
