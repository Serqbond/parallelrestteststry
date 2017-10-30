package serhii.test.resttests;

import assertions.AssertObjectsEquality;
import models.*;
import com.google.gson.*;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import serhii.test.BaseRestTest;

import java.util.Arrays;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

@Feature("REST Tests")
public class SearchTests extends BaseRestTest {

    private final String basePath = "/state";

    @Test
    @DisplayName("Search By Text")
    public void searchByText(){
        System.out.println("searchByText " + Thread.currentThread().getName());
        CountryInfo expectedCountryInfo = new CountryInfo()
                .setAbbr("AP")
                .setArea("49506799SKM")
                .setCapital("Hyderabad Amaravati")
                .setCountry("IND")
                .setLargest_city("Hyderabad Amaravati")
                .setName("Andhra Pradesh");

        String response = given(requestSpecification).get(basePath + "/search/IND?text=pradesh").body().asString();
        Gson gson = new Gson();
        StateResponse stateListResponse = gson.fromJson(response, StateResponse.class);

        CountryInfo actualIndia = Arrays.stream(stateListResponse.getCountryResponse().getCountryInfo())
                .filter(country -> country.getAbbr().equalsIgnoreCase(expectedCountryInfo.getAbbr()))
                .findFirst()
                .get();

        AssertObjectsEquality.assertCountryInfoEquality(expectedCountryInfo, actualIndia);
    }

    @Test
    @DisplayName("Search By Text With Deserializer")
    public void searchByTextWithDeserializer(){
        System.out.println("searchByTextWithDeserializer " + Thread.currentThread().getName());

        CountryInfo expectedCountryInfo = new CountryInfo()
                .setAbbr("AP")
                .setArea("49506799SKM")
                .setCapital("Hyderabad Amaravati")
                .setCountry("IND")
                .setLargest_city("Hyderabad Amaravati")
                .setName("Andhra Pradesh");

        String response = given(requestSpecification).get(basePath + "/search/IND?text=pradesh").body().asString();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(CountryInfo[].class, new CountryInfoDeserializer());
        Gson gson = gsonBuilder.create();
        StateResponse stateResponse = gson.fromJson(response, StateResponse.class);

        CountryInfo actualIndia = Arrays.stream(stateResponse.getCountryResponse().getCountryInfo())
                .filter(country -> country.getAbbr().equalsIgnoreCase(expectedCountryInfo.getAbbr()))
                .findFirst()
                .get();

        AssertObjectsEquality.assertCountryInfoEquality(expectedCountryInfo, actualIndia);
    }
}

