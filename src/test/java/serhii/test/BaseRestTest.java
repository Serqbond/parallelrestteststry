package serhii.test;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import io.restassured.RestAssured;

public class BaseRestTest {

    protected static RequestSpecification requestSpecification;
    protected static RestAssured client;

    @BeforeClass
    public static void setup() {
//        System.setProperty("http.proxyHost", "localhost");
//        System.setProperty("http.proxyPort", "8888");
        String baseHost = System.getenv("server.host");

        if(baseHost==null){
            baseHost = "http://services.groupkt.com";
        }

        client = new RestAssured();
        client.baseURI = baseHost;

        requestSpecification = new RequestSpecBuilder()
                //.log(LogDetail.HEADERS)
                .addFilter(new AllureRestAssured()).build();
    }
}
