package serhii.test;

import businessentities.CountryInfo;
import businessentities.CountryInfoDeserializer;
import businessentities.StateResponse;
import com.google.gson.*;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
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

    @Test
    public void getJsonBodyAndOtherHost(){
        System.out.println("getJsonBodyAndOtherHost " + Thread.currentThread().getName());
        String response = get(basePath + "/get/IND/UP").body().asString();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(CountryInfo[].class, new CountryInfoDeserializer());
        Gson gson = gsonBuilder.create();
        StateResponse stateResponse = gson.fromJson(response, StateResponse.class);
        Assert.assertEquals("Lucknow", Arrays.stream(stateResponse.getCountryResponse().getCountryInfo()).findFirst().get().getCapital());

        RestAssured rest =  new RestAssured();
        rest.baseURI = "http://api.openweathermap.org";
        rest.get("/data/2.5/weather?lat=35&lon=139").then().statusCode(401);
    }

    @Test
    public void playDateTime(){
        System.out.println("playDateTime " + Thread.currentThread().getName());

        LocalDateTime time = LocalDateTime.now();

        Assert.assertTrue("withSecond doesn't work. Expectd 5 , but was " + time.withSecond(5).getSecond(), time.withSecond(5).getSecond() == 5);

        String timeString = "2019-10-03T00:00";
        LocalDateTime fromStr = LocalDateTime.parse(timeString);
        LocalDateTime newFromStr = fromStr.plusHours(13).plusMinutes(86).plusSeconds(96).minusYears(2);

        Assert.assertFalse("Current year - "  + newFromStr.getYear() + " is not a leap year!" , newFromStr.toLocalDate().isLeapYear());
    }
}
