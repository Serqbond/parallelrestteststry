package serhii.test;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import uihelpers.WebDriverService;

import static io.restassured.RestAssured.given;

public class BaseTest {

    protected WebDriver driver;
    private WebDriverService webDriverService;
    protected String baseUrl;
    protected RequestSpecification requestSpecification;


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

        requestSpecification = new RequestSpecBuilder()
                //.log(LogDetail.HEADERS)
                .addFilter(new AllureRestAssured()).build();
    }

    @After
    public void finishTest(){
        webDriverService.stopDriver();
    }
}
