package step_definitions.order;

import context.TestContext;
import io.cucumber.java.en.When;
import pojo.request.UpdateOrder;
import step_definitions.hooks.BaseSteps;

public class UpdateAOrderStepDefs extends BaseSteps {

    public final TestContext context;


    public UpdateAOrderStepDefs(TestContext context) {
        this.context = context;
    }

    @When("The user sends PATCH request to {string} with valid orderId")
    public void theUserSendsUPDATERequestToWithValidOrderId(String endpoint) {
        response = context.getRequest().when().patch(endpoint + CreateNewOrderStepDefs.orderId);
        context.setResponse(response);
    }


    @When("The user sends PATCH request to {string} with different customer name as {string} valid orderId")
    public void theUserSendsPATCHRequestToWithDifferentCustomerNameAsValidOrderId(String endpoint, String customerName) {
        UpdateOrder updateOrder = new UpdateOrder(customerName);
        response = context.getRequest().contentType("application/json").body(updateOrder).when().patch(endpoint + CreateNewOrderStepDefs.orderId);
        context.setResponse(response);
    }
}
