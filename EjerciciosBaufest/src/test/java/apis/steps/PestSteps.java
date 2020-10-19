package apis.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonElement;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;

public class PestSteps {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private static final int OK_STATUS_CODE = 200;
    private static final String DEFAULT_PHOTO_LINK = "https://images.app.goo.gl/3hDbXmQ1VPu2d2YFA";
    private static Long petId;
    private static Response response;
    private static String jsonString;

    @Given("I add a pet name {string} and photo link {string} to the petstore")
    public void i_add_a_pet_name_and_photo_link_to_the_petstore(String petName, String photoLink) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"name\": \"" + petName + "\", \"photoUrls\": [\"" + photoLink + "\"]}")
                .post("/pet");

        jsonString = response.asString();
        System.out.println(jsonString);
        petId = JsonPath.from(jsonString).get("id");
        i_should_get_status_code(OK_STATUS_CODE);
    }

    @And("I get an existing pet")
    public void iGetAnExistingPet() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get("/pet/" + petId);
        i_should_get_status_code(OK_STATUS_CODE);
    }

    @When("I modify the name of the pet to {string}")
    public void i_modify_the_name_of_the_pet(String petName) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        JSONObject requestParams = new JSONObject();
        requestParams.put("id", petId);
        requestParams.put("name", petName);

        request.body(requestParams.toJSONString());
        response = request.put("/pet");
        System.out.println(response.asString());
    }

    @Then("I should get status code {int}")
    public void i_should_get_status_code(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

}
