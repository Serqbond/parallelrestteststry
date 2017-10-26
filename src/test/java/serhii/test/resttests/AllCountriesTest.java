package serhii.test.resttests;

import businessentities.StateResponse;
import com.google.gson.Gson;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.options;
import static org.hamcrest.CoreMatchers.is;

import serhii.test.BaseRestTest;

import java.util.Arrays;

@Feature("REST Tests")
public class AllCountriesTest extends BaseRestTest {

    private final String basePath = "/country";

    @Test
    @DisplayName("Get All Countries Test")
    public void getAllCountriesTest() {
        System.out.println("getAllCountriesTest " + Thread.currentThread().getName());
        given(requestSpecification).options(basePath + "/get/all").then().statusCode(200);
        given(requestSpecification).get(basePath + "/get/all").then().statusCode(200);
    }

    @Test
    @DisplayName("Get Country By Iso Code")
    public void getCountryByIsoCode(){
        System.out.println("getCountryByIsoCode " + Thread.currentThread().getName());
        given(requestSpecification).get(basePath + "/get/iso2code/IN").then()
                .body("RestResponse.result.name", is("India"));

    }

    @Test
    @DisplayName("No Matching Country")
    public void noMatchingCountry(){
        System.out.println("noMatchingCountry " + Thread.currentThread().getName());
        Gson gson = new Gson();
        String response = given(requestSpecification).get(basePath + "/get/iso2code/IU").body().asString();
        StateResponse stateResponse = gson.fromJson(response, StateResponse.class);
        Assert.assertEquals("No matching country found for requested code [IU].",
                Arrays.stream(stateResponse.getCountryResponse().getMessages()).findFirst().get());
    }
}
