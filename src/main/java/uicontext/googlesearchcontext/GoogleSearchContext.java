package uicontext.googlesearchcontext;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.googlesearch.GoogleSearchPage;
import uicontext.BaseContext;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class GoogleSearchContext extends BaseContext {
    private GoogleSearchPage googleSearchPage;

    public GoogleSearchContext(WebDriver driver){
        super(driver);
        googleSearchPage = new GoogleSearchPage(driver);
    }

    @Step("Open search page")
    public GoogleSearchContext opensTheSearchApp(String baseUrl) {
        googleSearchPage.open(baseUrl);
        makeScreenshot();
        return this;
    }

    @Step("Enter search text")
    public GoogleSearchContext searchesFor(String searchTerm) {
        googleSearchPage.enterSearchTerm(searchTerm);
        makeScreenshot();
        return this;
    }

    @Step("Verify expected result")
    public GoogleSearchContext shouldSeeTitle(String title) {
        makeScreenshot();
        assertThat(googleSearchPage.getTitle(), is(equalTo(title)));
        return this;
    }

    @Step("Verify expected result")
    public GoogleSearchContext shouldSeeSearchResult(String name) {
        googleSearchPage.getResults(name);
        makeScreenshot();
        return this;
    }
}
