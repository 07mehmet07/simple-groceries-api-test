package step_definitions.products;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import step_definitions.hooks.BaseSteps;

import static io.restassured.RestAssured.given;


public class GetAProductStepDefs extends BaseSteps {

    TestContext context;

    RequestSpecification request;

    public GetAProductStepDefs(TestContext context) {
        this.context = context;
    }

    @Given("The endpoint is accessed")
    public void theEndpointIsAccessed() {
        request = given();
        context.setRequest(request);
    }


    @When("The user sends to GET request to {string} with {string}")
    public void theUserSendsToGETRequestToWith(String endpoint, String id) {
        response = context.getRequest().when().get(endpoint + id);
        context.setResponse(response);
    }

    @And("The response id should be the same with specified {string}")
    public void theResponseIdShouldBeTheSameWithSpecifiedId(String id) {
        int responseId = context.getResponse().jsonPath().getInt("id");
        Assertions.assertThat(Integer.parseInt(id)).isEqualTo(responseId);
    }
}
