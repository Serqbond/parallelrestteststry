package uicontext;

import org.openqa.selenium.WebDriver;

public class BaseContext {
    protected WebDriver driver;

    public BaseContext(WebDriver driver){
        this.driver = driver;
    }
}
