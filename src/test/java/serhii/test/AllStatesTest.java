package serhii.test;

import businessentities.CountryInfo;
import businessentities.CountryInfoDeserializer;
import businessentities.StateResponse;
import com.google.gson.*;
import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Arrays;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.is;

public class AllStatesTest extends FunctionalTest{

    private final String basePath = "/state";

    @Test
    public void getStatusCodeTestCase(){
        System.out.println("getStatusCodeTestCase " + Thread.currentThread().getName());
        get(basePath + "/get/IND/UP").then().statusCode(200);
    }

    @Test
    public void getCapitalWorks(){
        System.out.println("getCapitalWorks " + Thread.currentThread().getName());
        get(basePath + "/get/IND/UP").then()
                .body("RestResponse.result.capital", is("Lucknow"));

    }

    @Test
    public void getJsonBody(){
        System.out.println("getJsonBody " + Thread.currentThread().getName());
        String response = get(basePath + "/get/IND/UP").body().asString();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(CountryInfo[].class, new CountryInfoDeserializer());
        Gson gson = gsonBuilder.create();
        StateResponse stateResponse = gson.fromJson(response, StateResponse.class);
        Assert.assertEquals("Lucknow", Arrays.stream(stateResponse.getCountryResponse().getCountryInfo()).findFirst().get().getCapital());
    }
}
