package uihelpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebDriverListener implements WebDriverEventListener {

    private WebDriver webDriver;

    public WebDriverListener(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    @Override
    public void beforeAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    @Step("Before navigating to url")
    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to url printing the browser associated capabilities");
    }

    @Step("After navigating to url")
    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.format("After navigating to %s printing the browser associated capabilities", url);
        System.out.println();
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    @Step("Looking for element")
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.format("Looking for element to \"%s\" printing the browser associated capabilities", by.toString());
        System.out.println();
    }

    @Step("After Looking for element")
    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.format("After Looking for element to \"%s\" printing the browser associated capabilities", by.toString());
        System.out.println();
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    }


    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }
}
