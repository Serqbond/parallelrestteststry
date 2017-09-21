package serhii.test;

import businessentities.StateResponse;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.options;
import static org.hamcrest.CoreMatchers.is;
import org.junit.runner.*;

public class AllCountriesTest extends FunctionalTest{

    @Test
    public void getAllCountriesTest() {
        System.out.println("getAllCountriesTest " + Thread.currentThread().getName());
        options("/country/get/all").then().statusCode(200);
        get("/country/get/all").then().statusCode(200);

    }

    @Test
    public void getCountryByIsoCode(){
        System.out.println("getCountryByIsoCode " + Thread.currentThread().getName());
        get("/country/get/iso2code/IN").then()
                .body("RestResponse.result.name", is("India"));

    }

    @Test
    public void noMatchingCountry(){
        System.out.println("noMatchingCountry " + Thread.currentThread().getName());
        Gson gson = new Gson();
        String response = get("/country/get/iso2code/IU").body().asString();
        StateResponse stateResponse = gson.fromJson(response, StateResponse.class);
        Assert.assertThat(stateResponse.getCountryResponse().getMessages()[0], CoreMatchers.containsString("More webservices"));
        Assert.assertEquals("No matching country found for requested code [IU].", stateResponse.getCountryResponse().getMessages()[1]);
    }
}
