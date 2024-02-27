package step_definitions.products;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import step_definitions.hooks.BaseSteps;

import java.util.List;


import static io.restassured.RestAssured.given;

public class GetAllProductsStepDefs extends BaseSteps {

    RequestSpecification request;

    TestContext context;

    public GetAllProductsStepDefs(TestContext context) {
        this.context = context;
    }

    @Given("The user choose query parameter {string} as {string}")
    public void theUserChooseCategoryAs(String query, String categoryName) {
        request = given().queryParam(query, categoryName);
        context.setRequest(request);
    }


    @And("The list of products should only contain {string}")
    public void theListOfProductsShouldOnlyContain(String categoryName) {
        List<String> categories = context.getResponse().jsonPath().getList("category");
        boolean isMatcedCategory = categories.stream().allMatch(category -> category.equals(categoryName));
        Assertions.assertThat(isMatcedCategory).isTrue();
    }

    @And("The list of products should only contain {string} for stock")
    public void theListOfProductsShouldOnlyContainForStock(String isInStock) {
        List<Boolean> inStocks = context.getResponse().jsonPath().getList("inStock");
        boolean isMatchedStock = inStocks.stream().allMatch(inStock -> isInStock.equals(inStock + ""));
        Assertions.assertThat(isMatchedStock).isTrue();
    }



}
