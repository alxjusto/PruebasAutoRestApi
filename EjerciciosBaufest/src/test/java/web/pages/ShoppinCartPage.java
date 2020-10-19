package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.utilities.ControlUserInterface;

public class ShoppinCartPage {

    WebDriver driver;

    public ShoppinCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    ControlUserInterface cui = new ControlUserInterface();

    private By categoryOption = By.xpath("//a[@id='itemc' and text()='%s']");
    private By product = By.xpath("//h4/a[text()='%s']");
    private By addedProduct = By.xpath("//tbody[@id='tbodyid']//td[text()='%s']");

    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement addToCartButton;

    public void choose_a_category(String categoryOption) {
        By updateElement = cui.updateXpath(this.categoryOption, categoryOption);
        cui.waitForElement(updateElement);
        driver.findElement(updateElement).click();
    }

    public void choose_a_product(String product) {
        By updateElement = cui.updateXpath(this.product, product);
        cui.waitForElement(updateElement);
        driver.findElement(updateElement).click();
    }

    public void add_product_to_shopping_cart() {
        cui.isPresent(addToCartButton);
        addToCartButton.click();
        cui.changeToAlert();
        cui.acceptAlert();
    }

    public String getProductName(String productName) {
        By updateElement = cui.updateXpath(this.addedProduct, productName);
        cui.waitForElement(updateElement);
        return driver.findElement(updateElement).getText();
    }
}
