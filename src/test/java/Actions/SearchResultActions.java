package Actions;

import Pages.SearchResultPage;
import org.openqa.selenium.WebDriver;

public class SearchResultActions {
    SearchResultPage searchResultPage;

    public SearchResultActions(WebDriver driver) {
        searchResultPage = new SearchResultPage(driver);
    }

    public String getHeaderText() {
        return searchResultPage.getHeaderText();
    }
}
