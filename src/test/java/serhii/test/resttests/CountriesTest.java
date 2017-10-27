package serhii.test.resttests;

import businessentities.serhii.be.allcountries.AllCountries;
import businessentities.serhii.be.allcountries.Result;
import com.google.gson.Gson;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import restcontext.RestContext;
import serhii.test.BaseRestTest;

import java.util.Arrays;
import java.util.Collection;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

@Feature("REST Tests")
@RunWith(Parameterized.class)
public class CountriesTest extends BaseRestTest {

    private final String countryGetAllPath  = "/country/get/all";

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
    @DisplayName("List Contains Specified Country Result")
    public void listContainsSpecifiedCountryResult(){
        System.out.println("listContainsSpecifiedCountryResult " + countryName + Thread.currentThread().getName());

        Result expectedAlgeria = new Result()
                .setName(countryName)
                .setAlpha2_code(alphaCode2)
                .setAlpha3_code(alphaCode3)
                ;


        String response = RestContext.given(requestSpecification)
                .get(countryGetAllPath)
                .body()
                .asString();

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
