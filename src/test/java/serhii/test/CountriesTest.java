package serhii.test;

import businessentities.serhii.be.allcountries.AllCountries;
import businessentities.serhii.be.allcountries.Result;
import com.google.gson.Gson;
import io.qameta.allure.Feature;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

@Feature("REST Tests")
@RunWith(Parameterized.class)
public class CountriesTest extends FunctionalTest{

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Algeria", "DZ", "DZA" }, { "India", "IN", "IND" }, { "Bermuda", "BM", "BMU" }
        });
    }

    private String countryName;
    private String alphaCode2;
    private String alphaCode3;

    public CountriesTest(String countryName, String alphaCode2, String alphaCode3 ) {
        this.countryName = countryName;
        this.alphaCode2 = alphaCode2;
        this.alphaCode3 = alphaCode3;
    }

    @Test
    public void listContainsSpecifiedCountryResult(){
        System.out.println("listContains " + countryName + Thread.currentThread().getName());

        Result expectedAlgeria = new Result()
                .setName(countryName)
                .setAlpha2_code(alphaCode2)
                .setAlpha3_code(alphaCode3)
                ;

        String response = given(requestSpecification).get("/country/get/all").body().asString();
        Gson gson = new Gson();
        AllCountries countries = gson.fromJson(response, AllCountries.class);

        Result actualAlgeria = Arrays.stream(countries.getRestResponse().getResult())
                .filter(country -> country.getName().equalsIgnoreCase(countryName))
                .findFirst()
                .get()
                ;

        Assert.assertEquals(expectedAlgeria.toString(), actualAlgeria.toString());
    }

}
