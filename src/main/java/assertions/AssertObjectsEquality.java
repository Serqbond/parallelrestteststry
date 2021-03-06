package assertions;

import models.CountryInfo;
import models.allcountries.Result;
import io.qameta.allure.Step;
import org.junit.Assert;

public class AssertObjectsEquality {

    @Step("Validate CountryInfo")
    public static void assertCountryInfoEquality(CountryInfo expected, CountryInfo actual){
        Assert.assertTrue("Capitals are different. Expected " + expected.getCapital() + " Actual: " + actual.getCapital(),
                actual.getCapital().equalsIgnoreCase(expected.getCapital()));
        Assert.assertTrue(actual.getAbbr().equalsIgnoreCase(expected.getAbbr()));
        Assert.assertTrue("Areas are different. Expected " + expected.getArea() + " Actual: " + actual.getArea(),
                actual.getArea().equalsIgnoreCase(expected.getArea()));
        Assert.assertTrue(actual.getCountry().equalsIgnoreCase(expected.getCountry()));
        Assert.assertTrue(actual.getLargestCity().equalsIgnoreCase(expected.getLargestCity()));
        Assert.assertTrue(actual.getName().equalsIgnoreCase(expected.getName()));
    }

    @Step("Validate Result")
    public static void assertResultObjectsEquality(Result actual, Result expected){
        Assert.assertEquals(actual.toString(), expected.toString());
    }
}
