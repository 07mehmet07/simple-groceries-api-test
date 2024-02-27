package context;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;

@Data
public class TestContext {
    private Response response;

    private RequestSpecification request;

    private String acessToken;
}
