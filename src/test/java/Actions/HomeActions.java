package Actions;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeActions {

    HomePage homePage;
    String searchTerm = "str";
    String selectedSuburb;
    public HomeActions(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public String selectSuburb() {
        homePage.enterIntoSearchField(searchTerm);
        selectedSuburb = homePage.selectFirstOption();
        homePage.clickSearchButton();

        return selectedSuburb;
    }


}
