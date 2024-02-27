package step_definitions.order;

import context.TestContext;
import io.cucumber.java.en.When;
import step_definitions.hooks.BaseSteps;

public class GetAOrderStepDefs extends BaseSteps {

    public final TestContext context;

    public GetAOrderStepDefs(TestContext context) {
        this.context = context;
    }

    @When("The user sends GET request to {string} with valid orderId")
    public void theUserSendsPOSTRequestToWithValidOrderId(String endpoint) {
        response = context.getRequest().when().get(endpoint + CreateNewOrderStepDefs.orderId);
        context.setResponse(response);
    }
}
