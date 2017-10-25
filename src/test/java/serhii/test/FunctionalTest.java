package serhii.test;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.BeforeClass;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class FunctionalTest {

    static RequestSpecification requestSpecification;

    @BeforeClass
    public static void setup() {
        System.setProperty("http.proxyHost", "localhost");
        System.setProperty("http.proxyPort", "8888");
        String baseHost = System.getenv("server.host");

        if(baseHost==null){
            baseHost = "http://services.groupkt.com";
        }

        RestAssured.baseURI = baseHost;

        requestSpecification = new RequestSpecBuilder()
                //.log(LogDetail.HEADERS)
                .addFilter(new AllureRestAssured()).build();
    }
}
