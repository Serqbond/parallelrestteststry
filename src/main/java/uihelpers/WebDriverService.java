package uihelpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverService {
    private WebDriver driver;
    private String baseUrl;

    public WebDriverService(){
//        System.setProperty("http.proxyHost", "localhost");
//        System.setProperty("http.proxyPort", "8888");
        initChromDriver();
        setBaseUrl();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void initChromDriver(){
        String driverPath = System.getenv("webdriver.chrome.driver");

        if(driverPath==null){
            driverPath = "src/drivers/chromedriver.exe";
        }

        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    private void setBaseUrl(){
        baseUrl = System.getenv("webdriver.base.url");
        if(baseUrl==null){
            baseUrl = "https://www.google.com.ua";
        }
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
