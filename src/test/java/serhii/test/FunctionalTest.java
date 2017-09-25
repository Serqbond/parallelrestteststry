package serhii.test;

import org.junit.BeforeClass;
import io.restassured.RestAssured;

public class FunctionalTest {

    @BeforeClass
    public static void setup() {
//        System.setProperty("http.proxyHost", "localhost");
//        System.setProperty("http.proxyPort", "8888");
        String baseHost = System.getenv("server.host");
        System.out.println(baseHost);

        if(baseHost==null){
            baseHost = "http://services.groupkt.com";
        }

        RestAssured.baseURI = baseHost;
    }
}
