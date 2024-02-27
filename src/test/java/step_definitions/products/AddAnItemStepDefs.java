package step_definitions.products;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import pojo.request.AddAnItemToCart;
import step_definitions.hooks.BaseSteps;
import step_definitions.cart.CreateCartStepDefs;

import static io.restassured.RestAssured.given;


public class AddAnItemStepDefs extends BaseSteps {
    TestContext context;

    RequestSpecification request;

    public static String itemId;

    public AddAnItemStepDefs(TestContext context) {
        this.context = context;
    }

    @Given("The product with {string} and the created cart are available")
    public void theProductWithAndTheCreatedCartAreAvailable(String productId) {
        AddAnItemToCart addAnItemToCart = new AddAnItemToCart(Integer.parseInt(productId));
        request = given().contentType("application/json").body(addAnItemToCart);
        context.setRequest(request);
    }

    @When("The user sends POST request to endpoint")
    public void theUserSendsPOSTRequestToEndpoint() {
        response = context.getRequest().when().post("/carts/" + CreateCartStepDefs.cartId + "/items");
        context.setResponse(response);
    }

    @And("The response item id can not be null")
    public void theResponseItemIdCanNotBeNull() {
        itemId = context.getResponse().jsonPath().getString("itemId");
        Assertions.assertThat(itemId).isNotEmpty();
    }
}
