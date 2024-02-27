package step_definitions.hooks;

import io.restassured.response.Response;
import utils.ConfigManager;
import static io.restassured.RestAssured.baseURI;

public abstract class BaseSteps {

    protected static Response response;

    public BaseSteps(){
        baseURI = ConfigManager.getProperty("baseURI");
    }


}
