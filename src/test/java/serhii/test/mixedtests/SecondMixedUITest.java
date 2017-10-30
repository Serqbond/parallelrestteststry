package serhii.test.mixedtests;

import models.allcountries.AllCountries;
import com.google.gson.Gson;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import serhii.test.BaseUITest;
import uicontext.googlesearchcontext.GoogleSearchContext;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

@Feature("Search For Test")
@DisplayName("Search For Banana Test in rest")
public class SecondMixedUITest extends BaseUITest {

    private final String basePath = "/country";

    @Test
    @DisplayName("Search For Banana Test")
    public void searchForBananaTest(){

        System.out.println("searchForBananaTest with REST " + Thread.currentThread().getName());

        GoogleSearchContext context = new GoogleSearchContext(driver);

        context
                .opensTheSearchApp(baseUrl)
                .searchesFor("banana")
                .shouldSeeTitle("banana - Пошук Google");

        String response = given(requestSpecification).get(basePath + "/get/all").body().asString();
        Gson gson = new Gson();
        AllCountries stateListResponse = gson.fromJson(response, AllCountries.class);
        Assert.assertEquals(Arrays.stream(stateListResponse.getRestResponse().getResult())
                        .filter(country -> country.getName().contains("Ukraine"))
                        .findFirst()
                        .get()
                        .getAlpha2_code(),
                "UA"
        );

        context
                .opensTheSearchApp(baseUrl)
                .searchesFor("banana")
                .shouldSeeTitle("banana - Пошук Google");
    }

    @Test
    @DisplayName("Search For Apple Test")
    public void searchForAppleTest(){

        System.out.println("searchForAppleTest with REST " + Thread.currentThread().getName());

        GoogleSearchContext context = new GoogleSearchContext(driver);

        context
                .opensTheSearchApp(baseUrl)
                .searchesFor("apple")
                .shouldSeeTitle("apple - Пошук Google");

        String response = given(requestSpecification).get(basePath + "/get/all").body().asString();
        Gson gson = new Gson();
        AllCountries stateListResponse = gson.fromJson(response, AllCountries.class);
        Assert.assertEquals(Arrays.stream(stateListResponse.getRestResponse().getResult())
                        .filter(country -> country.getName().contains("Ukraine"))
                        .findFirst()
                        .get()
                        .getAlpha2_code(),
                "UA"
        );

        context
                .opensTheSearchApp(baseUrl)
                .searchesFor("apple")
                .shouldSeeTitle("apple - Пошук Google");
    }
}
