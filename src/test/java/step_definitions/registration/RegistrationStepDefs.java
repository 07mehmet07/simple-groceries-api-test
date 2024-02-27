package step_definitions.registration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import pojo.request.UserRegistration;
import step_definitions.hooks.BaseSteps;


import static io.restassured.RestAssured.given;


public class RegistrationStepDefs extends BaseSteps {
    static RequestSpecification request;

    static ObjectMapper mapper = new ObjectMapper();

    public static String accessToken;

    TestContext context;

    public RegistrationStepDefs(TestContext context) {
        this.context = context;
    }

    @Given("The user has valid credentials as {string} and {string}")
    public void theUserHasValidCredentialsAsAnd(String clientName, String clientEmail) {
        UserRegistration userRegistration = new UserRegistration(clientName, clientEmail);
        try {
            String jsonBody = mapper.writeValueAsString(userRegistration);
            request = given().contentType("application/json").body(jsonBody);
            context.setRequest(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


    @And("The response access token is not empty")
    public void theResponseHasAnAccessToken() {
        accessToken = context.getResponse().jsonPath().getString("accessToken");
        Assertions.assertThat(accessToken).isNotEmpty();
    }
}
