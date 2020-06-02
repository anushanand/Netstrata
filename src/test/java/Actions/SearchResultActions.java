package Actions;

import Pages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchResultActions {
    SearchResultPage searchResultPage;

    public SearchResultActions(WebDriver driver) {
        searchResultPage = new SearchResultPage(driver);
    }

    public String getHeaderText() {
        return searchResultPage.getHeaderText();
    }

    public void verifySuburb(String selectedSuburb) {
        Assert.assertTrue(getHeaderText().contains(selectedSuburb));
    }
}
