package restcontext;

import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;

public class RestContext {

    @Step("Setup rest-assured report")
    public static RequestSpecification given(RequestSpecification requestSpecification) {
        return given(requestSpecification);
    }
}
