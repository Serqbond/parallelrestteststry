package serhii.test.mixedtests;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import uihelpers.WebDriverService;

public class BaseTest {

    protected WebDriver driver;
    private WebDriverService webDriverService;
    protected String baseUrl;

    @Before
    public void startTest(){
        webDriverService = new WebDriverService();
        driver = webDriverService.getDriver();
        baseUrl = webDriverService.getBaseUrl();

//        System.setProperty("http.proxyHost", "localhost");
//        System.setProperty("http.proxyPort", "8888");

        String baseHost = System.getenv("server.host");
        System.out.println(baseHost);

        if(baseHost==null){
            baseHost = "http://services.groupkt.com";
        }

        RestAssured.baseURI = baseHost;
    }

    @After
    public void finishTest(){
        webDriverService.stopDriver();
    }
}
