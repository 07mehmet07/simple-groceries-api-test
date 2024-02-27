package step_definitions.cart;

import context.TestContext;
import io.cucumber.java.en.When;
import step_definitions.hooks.BaseSteps;
import step_definitions.products.AddAnItemStepDefs;

public class DeleteAnItemStepDefs extends BaseSteps {

    TestContext context;

    public DeleteAnItemStepDefs(TestContext context) {
        this.context = context;
    }

    @When("The user sends DELETE request to endpoint")
    public void theUserSendsDELETERequestToEndpoint() {
        response = context.getRequest().when().delete("/carts/" + CreateCartStepDefs.cartId + "/items/" + AddAnItemStepDefs.itemId);
        context.setResponse(response);
    }


}
