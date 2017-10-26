package assertions;

import businessentities.CountryInfo;
import io.qameta.allure.Step;
import org.testng.Assert;
//import org.junit.Assert;


public class AssertObjectsEquality {

    @Step("Validate CountryInfo")
    public static void assertCountryInfoEquality(CountryInfo expected, CountryInfo actual){
        Assert.assertTrue(actual.getCapital().equalsIgnoreCase(expected.getCapital()),
                "Capitals are different. Expected " + expected.getCapital() + " Actual: " + actual.getCapital());
        Assert.assertTrue(actual.getAbbr().equalsIgnoreCase(expected.getAbbr()));
        Assert.assertTrue(actual.getArea().equalsIgnoreCase(expected.getArea()),
                "Areas are different. Expected " + expected.getArea() + " Actual: " + actual.getArea());
        Assert.assertTrue(actual.getCountry().equalsIgnoreCase(expected.getCountry()));
        Assert.assertTrue(actual.getLargestCity().equalsIgnoreCase(expected.getLargestCity()));
        Assert.assertTrue(actual.getName().equalsIgnoreCase(expected.getName()));
    }

    @Step("Validate Country string represantation")
    public static void assertCountryStringEquality(String actual, String expected){
        Assert.assertEquals(actual, expected);
    }
}
