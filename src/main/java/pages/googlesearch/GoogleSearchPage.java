package pages.googlesearch;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utilities.Utilities;

public class GoogleSearchPage extends BasePage{
    public GoogleSearchPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="lst-ib")
    WebElement serchTextField;

    public WebElement getResults (String textToSearch){
        String xPath = "//a[contains(., '" + textToSearch + "')]";
        WebElement element = this.driver.findElement(By.xpath(xPath));
        Utilities.Highlight(this.driver, element);
        return element;
    }

    public void enterSearchTerm(String searchTerm) {
        serchTextField.sendKeys(searchTerm + "\n");
    }
}
