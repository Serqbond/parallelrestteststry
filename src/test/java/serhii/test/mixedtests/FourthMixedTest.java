package serhii.test.mixedtests;

import businessentities.serhii.be.allcountries.AllCountries;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;
import serhii.test.BaseTest;
import uicontext.googlesearchcontext.GoogleSearchContext;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

@Test(suiteName = "Fourth Mixed Test")
public class FourthMixedTest extends BaseTest{
    private final String basePath = "/country";

    @Test(description = "Search For Piano Test")
    public void searchForPianoTest() {

        System.out.println("searchForPianoTest with REST " + Thread.currentThread().getName());

        GoogleSearchContext context = new GoogleSearchContext(driver);

        context
                .opensTheSearchApp(baseUrl)
                .searchesFor("Piano")
                .shouldSeeTitle("Piano - Пошук Google");

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
    }
}
