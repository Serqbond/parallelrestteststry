package serhii.test;

import businessentities.StateResponse;
import businessentities.serhii.be.allcountries.AllCountries;
import businessentities.serhii.be.allcountries.Result;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.get;

public class CountryListTest extends FunctionalTest {

    @Test
    public void listContainsUkraine(){
        System.out.println("listContainsUkraine " + Thread.currentThread().getName());
        Gson gson = new Gson();
        String response = get("/country/get/all").body().asString();

        AllCountries stateListResponse = gson.fromJson(response, AllCountries.class);

        Assert.assertEquals("UA", Arrays.stream(stateListResponse.getRestResponse().getResult())
                .filter(country -> country.getName().contains("Ukraine"))
                .findFirst()
                .get()
                .getAlpha2_code()
        );
    }

    @Test
    public void listContainsAlgeriaResult(){
        System.out.println("listContainsAlgeria " + Thread.currentThread().getName());

        Result expectedAlgeria = new Result()
                .setName("Algeria")
                .setAlpha2_code("DZ")
                .setAlpha3_code("DZA")
                ;

        AllCountries countries  = get("/country/get/all").as(AllCountries.class);

        Result actualAlgeria = Arrays.stream(countries.getRestResponse().getResult())
                .filter(country -> country.getName().contains("Algeria"))
                .findFirst()
                .get()
                ;

        Assert.assertEquals(expectedAlgeria.toString(), actualAlgeria.toString());
    }
}
