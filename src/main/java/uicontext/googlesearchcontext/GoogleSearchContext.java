package uicontext.googlesearchcontext;

//import io.qameta.allure.Step;
import ru.yandex.qatools.allure.annotations.Step;
import org.openqa.selenium.WebDriver;
import pages.googlesearch.GoogleSearchPage;
import uicontext.BaseContext;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class GoogleSearchContext extends BaseContext {
    private GoogleSearchPage googleSearchPage;

    public GoogleSearchContext(WebDriver driver){
        googleSearchPage = new GoogleSearchPage(driver);
    }

    @Step("Open search page")
    public GoogleSearchContext opensTheSearchApp(String baseUrl) {
        googleSearchPage.open(baseUrl);
        return this;
    }

    @Step("Enter search text")
    public GoogleSearchContext searchesFor(String searchTerm) {
        googleSearchPage.enterSearchTerm(searchTerm);
        return this;
    }

    @Step("Verify expected result")
    public GoogleSearchContext shouldSeeTitle(String title) {
        assertThat(googleSearchPage.getTitle(), is(equalTo(title)));
        return this;
    }
}
