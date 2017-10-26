package uicontext;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BaseContext {
    protected WebDriver driver;

    public BaseContext(WebDriver driver){
        this.driver = driver;
    }

    @Attachment(value = "Screen "{0}"", type = "image/png")
    public byte[] makeScreenshot(String name) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
