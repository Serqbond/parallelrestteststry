package serhii.test.mixedtests;

import assertions.AssertObjectsEquality;
import businessentities.CountryInfo;
import businessentities.StateResponse;
import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import uicontext.googlesearchcontext.GoogleSearchContext;
import java.util.Arrays;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

@Feature("Search For Pear Test")
@DisplayName("Search For Pear Test in rest")
public class FirstMixedTest extends BaseTest{

    private final String basePath = "/state";

    @Test
    @DisplayName("Search For Pear Test")
    @Description("In this cool test we will test only cool features")
    public void searchForPearTest(){

        System.out.println("searchForPearTest with REST " + Thread.currentThread().getName());
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL).addFilter(new AllureRestAssured()).build();

        CountryInfo expectedCountryInfo = new CountryInfo()
                .setAbbr("AP")
                .setArea("49506799SKM")
                .setCapital("Hyderabad Amaravati")
                .setCountry("IND")
                .setLargest_city("Hyderabad Amaravati")
                .setName("Andhra Pradesh");

        GoogleSearchContext context = new GoogleSearchContext(driver);

        context
                .opensTheSearchApp(baseUrl)
                .searchesFor("pear")
                .shouldSeeTitle("pear - Пошук Google");

        String response = given(requestSpecification).get(basePath + "/search/IND?text=pradesh").body().asString();
        //new AllureRestAssured().filter();
        Gson gson = new Gson();
        StateResponse stateListResponse = gson.fromJson(response, StateResponse.class);

        CountryInfo actualIndia = Arrays.stream(stateListResponse.getCountryResponse().getCountryInfo())
                .filter(country -> country.getAbbr().equalsIgnoreCase(expectedCountryInfo.getAbbr()))
                .findFirst()
                .get();

        AssertObjectsEquality.assertCountryInfoEquality(expectedCountryInfo, actualIndia);

        new GoogleSearchContext(driver)
                .opensTheSearchApp(baseUrl)
                .searchesFor("pear")
                .shouldSeeTitle("pear - Пошук Google");

//        @Step("Get response");
        response = given(requestSpecification).get(basePath + "/search/IND?text=pradesh").body().asString();
        gson = new Gson();
        stateListResponse = gson.fromJson(response, StateResponse.class);

        actualIndia = Arrays.stream(stateListResponse.getCountryResponse().getCountryInfo())
                .filter(country -> country.getAbbr().equalsIgnoreCase(expectedCountryInfo.getAbbr()))
                .findFirst()
                .get();

        AssertObjectsEquality.assertCountryInfoEquality(expectedCountryInfo, actualIndia);
    }
}
