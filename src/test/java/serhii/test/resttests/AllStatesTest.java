package serhii.test.resttests;

import models.CountryInfo;
import models.CountryInfoDeserializer;
import models.StateResponse;
import com.google.gson.*;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.Assert;
import org.junit.Test;
import serhii.test.BaseRestTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@Feature("REST Tests")
public class AllStatesTest extends BaseRestTest {

    private final String basePath = "/state";

    @Test
    @DisplayName("Get Status Code Test Case")
    public void getStatusCodeTestCase(){
        System.out.println("getStatusCodeTestCase " + Thread.currentThread().getName());
        given(requestSpecification).get(basePath + "/get/IND/UP").then().statusCode(200);
    }

    @Test
    @DisplayName("Get Capital Works")
    public void getCapitalWorks(){
        System.out.println("getCapitalWorks " + Thread.currentThread().getName());
        given(requestSpecification).get(basePath + "/get/IND/UP").then()
                .body("RestResponse.result.capital", is("Lucknow"));

    }

    @Test
    @DisplayName("Get Json Body")
    public void getJsonBody(){
        System.out.println("getJsonBody " + Thread.currentThread().getName());
        String response = given(requestSpecification).get(basePath + "/get/IND/UP").body().asString();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(CountryInfo[].class, new CountryInfoDeserializer());
        Gson gson = gsonBuilder.create();
        StateResponse stateResponse = gson.fromJson(response, StateResponse.class);
        Assert.assertEquals("Lucknow", Arrays.stream(stateResponse.getCountryResponse().getCountryInfo()).findFirst().get().getCapital());
    }

    @Test
    @DisplayName("Get Json Body And Other Host")
    public void getJsonBodyAndOtherHost(){
        System.out.println("getJsonBodyAndOtherHost " + Thread.currentThread().getName());
        String response = given(requestSpecification).get(basePath + "/get/IND/UP").body().asString();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(CountryInfo[].class, new CountryInfoDeserializer());
        Gson gson = gsonBuilder.create();
        StateResponse stateResponse = gson.fromJson(response, StateResponse.class);
        Assert.assertEquals("Lucknow", Arrays.stream(stateResponse.getCountryResponse().getCountryInfo()).findFirst().get().getCapital());

        RestAssured rest =  new RestAssured();
        rest.baseURI = "http://api.openweathermap.org";
        rest.given(new RequestSpecBuilder()
                .addFilter(new AllureRestAssured()).build())
                .get("/data/2.5/weather?lat=35&lon=139").then().statusCode(401);
    }

    @Test
    @DisplayName("Play Date Time")
    public void playDateTime(){
        System.out.println("playDateTime " + Thread.currentThread().getName());

        LocalDateTime time = LocalDateTime.now();

        Assert.assertTrue("withSecond doesn't work. Expected 5 , but was " + time.withSecond(5).getSecond(), time.withSecond(5).getSecond() == 5);

        String timeString = "2019-10-03T00:00";
        LocalDateTime fromStr = LocalDateTime.parse(timeString);
        LocalDateTime newFromStr = fromStr.plusHours(13).plusMinutes(86).plusSeconds(96).minusYears(2);

        Assert.assertFalse("Current year - "  + newFromStr.getYear() + " is not a leap year!" , newFromStr.toLocalDate().isLeapYear());
    }
}
