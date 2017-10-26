package serhii.test.resttests;

import assertions.AssertObjectsEquality;
import businessentities.serhii.be.allcountries.AllCountries;
import businessentities.serhii.be.allcountries.Result;
import com.google.gson.Gson;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import serhii.test.BaseRestTest;

import java.util.Arrays;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

@Feature("REST Tests")
public class CountryListTest extends BaseRestTest {

    private final String basePath = "/country";

    @Test
    @DisplayName("List Contains Ukraine")
    public void listContainsUkraine(){
        System.out.println("listContainsUkraine " + Thread.currentThread().getName());
        Gson gson = new Gson();
        String response = given(requestSpecification).get(basePath + "/get/all").body().asString();

        AllCountries stateListResponse = gson.fromJson(response, AllCountries.class);

        Assert.assertEquals("UA", Arrays.stream(stateListResponse.getRestResponse().getResult())
                .filter(country -> country.getName().contains("Ukraine"))
                .findFirst()
                .get()
                .getAlpha2_code()
        );
    }

    @Test
    @DisplayName("List Contains Algeria Result")
    public void listContainsAlgeriaResult(){
        System.out.println("listContainsAlgeria " + Thread.currentThread().getName());

        Result expectedAlgeria = new Result()
                .setName("Algeria")
                .setAlpha2_code("DZ")
                .setAlpha3_code("DZA")
                ;

        String response = given(requestSpecification).get(basePath + "/get/all").body().asString();
        Gson gson = new Gson();
        AllCountries countries = gson.fromJson(response, AllCountries.class);

        Result actualAlgeria = Arrays.stream(countries.getRestResponse().getResult())
                .filter(country -> country.getName().contains("Algeria"))
                .findFirst()
                .get()
                ;

        AssertObjectsEquality.assertResultObjectsEquality(actualAlgeria, expectedAlgeria);
    }
}
