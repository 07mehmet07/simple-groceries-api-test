package step_definitions.cart;

import context.TestContext;
import io.cucumber.java.en.And;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import step_definitions.hooks.BaseSteps;

@AllArgsConstructor
public class CreateCartStepDefs extends BaseSteps {

    TestContext context;

    public static String cartId;


    @And("The response cart id can not be empty")
    public void theResponseCartIdCanNotBeEmpty() {
        response = context.getResponse();
        cartId = response.jsonPath().getString("cartId");
        Assertions.assertThat(cartId).isNotEmpty();
    }
}
