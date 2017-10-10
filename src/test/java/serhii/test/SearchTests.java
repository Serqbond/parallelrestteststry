package serhii.test;

import businessentities.*;
import com.google.gson.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

import static io.restassured.RestAssured.get;

public class SearchTests extends FunctionalTest{

    private final String basePath = "/state";

    @Test
    public void searchByText(){
        System.out.println("searchByText " + Thread.currentThread().getName());
        CountryInfo expectedCountryInfo = new CountryInfo()
                .setAbbr("AP")
                .setArea("49506799SKM")
                .setCapital("Hyderabad Amaravati")
                .setCountry("IND")
                .setLargest_city("Hyderabad Amaravati")
                .setName("Andhra Pradesh");

        String response = get(basePath + "/search/IND?text=pradesh").body().asString();
        Gson gson = new Gson();
        StateResponse stateListResponse = gson.fromJson(response, StateResponse.class);

        CountryInfo actualIndia = Arrays.stream(stateListResponse.getCountryResponse().getCountryInfo())
                .filter(country -> country.getAbbr().equalsIgnoreCase(expectedCountryInfo.getAbbr()))
                .findFirst()
                .get();

        Assert.assertTrue("Capitals are different. Expected " + expectedCountryInfo.getCapital() + " Actual: " + actualIndia.getCapital(),
                actualIndia.getCapital().equalsIgnoreCase(expectedCountryInfo.getCapital()));
        Assert.assertTrue(actualIndia.getAbbr().equalsIgnoreCase(expectedCountryInfo.getAbbr()));
        Assert.assertTrue("Areas are different. Expected " + expectedCountryInfo.getArea() + " Actual: " + actualIndia.getArea(),
                actualIndia.getArea().equalsIgnoreCase(expectedCountryInfo.getArea()));
        Assert.assertTrue(actualIndia.getCountry().equalsIgnoreCase(expectedCountryInfo.getCountry()));
        Assert.assertTrue(actualIndia.getLargestCity().equalsIgnoreCase(expectedCountryInfo.getLargestCity()));
        Assert.assertTrue(actualIndia.getName().equalsIgnoreCase(expectedCountryInfo.getName()));
    }

    @Test
    public void searchByTextWithDeserializer(){
        System.out.println("searchByTextWithDeserializer " + Thread.currentThread().getName());
        CountryInfo expectedCountryInfo = new CountryInfo()
                .setAbbr("AP")
                .setArea("49506799SKM")
                .setCapital("Hyderabad Amaravati")
                .setCountry("IND")
                .setLargest_city("Hyderabad Amaravati")
                .setName("Andhra Pradesh");

        String response = get(basePath + "/search/IND?text=pradesh").body().asString();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(CountryInfo[].class, new CountryInfoDeserializer());
        Gson gson = gsonBuilder.create();
        StateResponse stateResponse = gson.fromJson(response, StateResponse.class);

        CountryInfo actualIndia = Arrays.stream(stateResponse.getCountryResponse().getCountryInfo())
                .filter(country -> country.getAbbr().equalsIgnoreCase(expectedCountryInfo.getAbbr()))
                .findFirst()
                .get();

        Assert.assertTrue(stateResponse.getCountryResponse().getCountryInfo().length == 5);
        Assert.assertTrue("Capitals are different. Expected " + expectedCountryInfo.getCapital() + " Actual: " + actualIndia.getCapital(),
                actualIndia.getCapital().equalsIgnoreCase(expectedCountryInfo.getCapital()));
        Assert.assertTrue(actualIndia.getAbbr().equalsIgnoreCase(expectedCountryInfo.getAbbr()));
        Assert.assertTrue("Areas are different. Expected " + expectedCountryInfo.getArea() + " Actual: " + actualIndia.getArea(),
                actualIndia.getArea().equalsIgnoreCase(expectedCountryInfo.getArea()));
        Assert.assertTrue(actualIndia.getCountry().equalsIgnoreCase(expectedCountryInfo.getCountry()));
        Assert.assertTrue(actualIndia.getLargestCity().equalsIgnoreCase(expectedCountryInfo.getLargestCity()));
        Assert.assertTrue(actualIndia.getName().equalsIgnoreCase(expectedCountryInfo.getName()));
    }
}

