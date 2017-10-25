package pages.googlesearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class GoogleSearchPage extends BasePage{
    public GoogleSearchPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="lst-ib")
    WebElement serchTextField;

    public WebElement getResults (String textToSearch){
        String xPath = "//a[contains(., '" + textToSearch + "')]";
        return this.driver.findElement(By.xpath(xPath));
    }

    public void enterSearchTerm(String searchTerm) {
        serchTextField.sendKeys(searchTerm + "\n");
    }
}
