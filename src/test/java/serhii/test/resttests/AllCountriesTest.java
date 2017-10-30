package serhii.test.resttests;

import models.StateResponse;
import com.google.gson.Gson;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import serhii.test.BaseRestTest;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@Feature("REST Tests")
public class AllCountriesTest extends BaseRestTest {

    private final String basePath = "/country";
    private final String getAllUrl = "/get/all";
    private final String getIsoCodeWithParam = "/get/iso2code/%s";


    @Test
    @DisplayName("Get All Countries Test")
    public void getAllCountriesTest() {
        System.out.println("getAllCountriesTest " + Thread.currentThread().getName());
        given(requestSpecification)
                .options(basePath + getAllUrl)
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Get Country By Iso Code")
    public void getCountryByIsoCode(){
        String indiaCode = "IN";
        System.out.println("getCountryByIsoCode " + Thread.currentThread().getName());
        given(requestSpecification)
                .get(basePath + String.format(getIsoCodeWithParam, indiaCode))
                .then()
                .body("RestResponse.result.name", is("India"));
    }

    @Test
    @DisplayName("No Matching Country")
    public void noMatchingCountry(){
        System.out.println("noMatchingCountry " + Thread.currentThread().getName());
        String noCountryCode = "IU";
        String response = given(requestSpecification)
                .get(basePath + String.format(getIsoCodeWithParam, noCountryCode))
                .body()
                .asString();

        Gson gson = new Gson();
        StateResponse stateResponse = gson.fromJson(response, StateResponse.class);
        Assert.assertEquals(String.format("No matching country found for requested code [%s].", noCountryCode),
                Arrays.stream(stateResponse.getCountryResponse().getMessages()).findFirst().get());
    }
}
