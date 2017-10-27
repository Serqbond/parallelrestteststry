package uihelpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

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
        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        EventFiringWebDriver efwd = new EventFiringWebDriver(chromeDriver);
        WebDriverListener eventListener = new WebDriverListener(chromeDriver);
        efwd.register(eventListener);
        driver = efwd;
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
