package step_definitions.order;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import pojo.request.CreateOrder;
import org.assertj.core.api.Assertions;
import step_definitions.hooks.BaseSteps;
import step_definitions.registration.RegistrationStepDefs;
import step_definitions.cart.CreateCartStepDefs;

import static io.restassured.RestAssured.given;

public class CreateNewOrderStepDefs extends BaseSteps {
    TestContext context;

    public static String orderId;

    public CreateNewOrderStepDefs(TestContext context) {
        this.context = context;
    }

    @Given("The user has cart id and customer name as {string}")
    public void theUserHasCartIdAndCustomerNameAs(String customerName) {
        CreateOrder createOrder = new CreateOrder(CreateCartStepDefs.cartId, customerName);
        RequestSpecification request = given().header("Authorization", "Bearer " + RegistrationStepDefs.accessToken).
                contentType("application/json").body(createOrder);
        context.setRequest(request);
    }

    @When("The user sends POST request to available endpoint")
    public void theUserSendsPOSTRequestToAvailableEndpoint() {
        response = context.getRequest().when().post("/orders");
        context.setResponse(response);
    }

    @And("The response order id can not be null")
    public void theResponseOrderIdCanNotBeNull() {
        orderId = context.getResponse().jsonPath().getString("orderId");

        Assertions.assertThat(orderId).isNotEmpty();
    }
}
