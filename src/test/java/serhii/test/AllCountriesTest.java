package serhii.test;

import businessentities.StateResponse;
import com.google.gson.Gson;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.options;
import static org.hamcrest.CoreMatchers.is;
import org.junit.runner.*;

import java.util.Arrays;

@Feature("REST Tests")
public class AllCountriesTest extends FunctionalTest{

    private final String basePath = "/country";

    @Test
    public void getAllCountriesTest() {
        System.out.println("getAllCountriesTest " + Thread.currentThread().getName());
        given(requestSpecification).options(basePath + "/get/all").then().statusCode(200);
        given(requestSpecification).get(basePath + "/get/all").then().statusCode(200);

    }

    @Test
    public void getCountryByIsoCode(){
        System.out.println("getCountryByIsoCode " + Thread.currentThread().getName());
        given(requestSpecification).get(basePath + "/get/iso2code/IN").then()
                .body("RestResponse.result.name", is("India"));

    }

    @Test
    public void noMatchingCountry(){
        System.out.println("noMatchingCountry " + Thread.currentThread().getName());
        Gson gson = new Gson();
        String response = given(requestSpecification).get(basePath + "/get/iso2code/IU").body().asString();
        StateResponse stateResponse = gson.fromJson(response, StateResponse.class);
        Assert.assertEquals("No matching country found for requested code [IU].",
                Arrays.stream(stateResponse.getCountryResponse().getMessages()).findFirst().get());
    }
}
