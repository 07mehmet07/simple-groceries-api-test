package step_definitions;

import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;


public class CommonSteps{

    public TestContext context;

    public CommonSteps(TestContext context) {
        this.context = context;
    }


    @Then("The response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        Response response = context.getResponse();
        Assertions.assertThat(response.getStatusCode()).as("Wrong status code").isEqualTo(statusCode);
    }

    @When("The user sends POST request to {string}")
    public void theUserSendsPOSTRequestTo(String endpoint) {
        RequestSpecification request = context.getRequest();
        Response response = request.when().post(endpoint);
        context.setResponse(response);
    }

    @When("The user sends to GET request to {string}")
    public void theUserSendsToGETRequestTo(String endpoint) {
        RequestSpecification request = context.getRequest();
        Response response = request.when().get(endpoint);
        context.setResponse(response);
    }

}
