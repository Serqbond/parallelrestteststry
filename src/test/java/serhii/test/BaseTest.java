package serhii.test;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import uihelpers.WebDriverService;

public class BaseTest {

    protected WebDriver driver;
    private WebDriverService webDriverService;
    protected String baseUrl;
    protected RequestSpecification requestSpecification;


    @BeforeMethod
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

    @AfterMethod
    public void finishTest(){
        webDriverService.stopDriver();
    }
}
