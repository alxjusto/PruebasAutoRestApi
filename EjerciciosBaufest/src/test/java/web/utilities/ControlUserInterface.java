package web.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.driver.BaseDriver;

import java.util.concurrent.TimeUnit;

public class ControlUserInterface extends BaseDriver {

    Alert alert;

    public void go_url(String url) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(String.valueOf(40)), TimeUnit.SECONDS);
        driver.get(url);
    }

    public void waitForElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void isPresent(WebElement elemento) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(elemento));
    }

    public void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public By updateXpath(By element, String addValue) {
        String auxXpath = element.toString();
        auxXpath = auxXpath.substring(auxXpath.indexOf("//"));
        auxXpath = String.format(auxXpath, addValue);
        return By.xpath(auxXpath);
    }

    public void changeToAlert() {
        waitForAlert();
        alert = driver.switchTo().alert();
    }

    public String getTextFromAlert() {
        return alert.getText();
    }

    public void acceptAlert() {
        alert.accept();
    }
}
