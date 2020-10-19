package web.run;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import web.driver.BaseDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/main/resources/Features/web/Login.feature",
        "src/main/resources/Features/web/ShoppingCart.feature"},
        glue = {"web.steps"},
        tags = {"not @tag", "@wip"},
        plugin = {"json:target/cucumber-reports/Cucumber.json"},
        monochrome = true)
public class Runner {

    static BaseDriver bd = new BaseDriver();

    @BeforeClass
    public static void iniciarDriver() throws Exception {
        bd.inicializarDriver();
    }

    @AfterClass
    public static void cerrarDriver() {
        bd.finalizarDriver();
    }

}


