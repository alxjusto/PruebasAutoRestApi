package apis.run;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/Features/api/Pets.feature",
        glue = {"apis.steps"},
        tags = {"not @tag", "@wip"}
)
public class APIRunner {
}