package web.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import web.driver.BaseDriver;
import web.pages.LoginPage;
import web.pages.ShoppinCartPage;
import web.utilities.ControlUserInterface;

public class ShoppingCartStep extends BaseDriver {

    ShoppinCartPage shoppinCartPage = new ShoppinCartPage(driver);

    @Given("I chose categories {string}")
    public void i_chose_categories(String categoryOption) {
        shoppinCartPage.choose_a_category(categoryOption);
    }

    @Given("I chose a product {string}")
    public void i_chose_a_product(String product) {
        shoppinCartPage.choose_a_product(product);
    }

    @Then("I should see name of the product {string}")
    public void i_should_see_name_of_the_product(String productName) {
        Assert.assertEquals("We verify just add product", productName, shoppinCartPage.getProductName(productName));
    }

    @When("I add the product to shopping cart")
    public void iAddTheProductToShoppingCart() {
        shoppinCartPage.add_product_to_shopping_cart();
    }
}
