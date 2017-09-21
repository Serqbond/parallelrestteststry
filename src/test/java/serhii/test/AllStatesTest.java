package serhii.test;

import businessentities.StateResponse;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.is;

public class AllStatesTest extends FunctionalTest{

    @Test
    public void getStatusCodeTestCase(){
        System.out.println("getStatusCodeTestCase " + Thread.currentThread().getName());
        get("/state/get/IND/UP").then().statusCode(200);
    }

    @Test
    public void getCapitalWorks(){
        System.out.println("getCapitalWorks " + Thread.currentThread().getName());
        get("/state/get/IND/UP").then()
                .body("RestResponse.result.capital", is("Lucknow"));

    }

    @Test
    public void getJsonBody(){
        System.out.println("getJsonBody " + Thread.currentThread().getName());
        Gson gson = new Gson();
        String response = get("/state/get/IND/UP").body().asString();
        StateResponse stateResponse = gson.fromJson(response, StateResponse.class);
        Assert.assertEquals("Lucknow", stateResponse.getCountryResponse().getCountryInfo().getCapital());
    }
}
