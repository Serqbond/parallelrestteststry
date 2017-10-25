package serhii.test.resttests;

import businessentities.serhii.be.allcountries.AllCountries;
import businessentities.serhii.be.allcountries.Result;
import com.google.gson.Gson;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import serhii.test.FunctionalTest;
import java.util.Arrays;
import static io.restassured.RestAssured.given;

@Test(suiteName = "Countries tests")
@Feature("Countries")
public class CountriesTest extends FunctionalTest {

    @DataProvider(name = "countries")
    public Object[][] createData1() {
        return new Object[][] {
                { "Algeria", "DZ", "DZA" },
                { "India", "IN", "IND" },
                { "Bermuda", "BM", "BMU" }
        };
    }

    @Test(dataProvider = "countries")
    public void listContainsSpecifiedCountryResult(String countryName, String alphaCode2, String alphaCode3){
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

        Assert.assertEquals(actualAlgeria.toString(), expectedAlgeria.toString());
    }

}