package step_definitions.order;

import context.TestContext;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;
import step_definitions.hooks.BaseSteps;

@AllArgsConstructor

public class DeleteOrderStepDefs extends BaseSteps {

    public final TestContext context;

    @When("The user sends DELETE request to {string} with valid orderId")
    public void theUserSendsDELETERequestToWithValidOrderId(String endpoint) {
        response = context.getRequest().delete(endpoint + CreateNewOrderStepDefs.orderId);
        context.setResponse(response);
    }
}
