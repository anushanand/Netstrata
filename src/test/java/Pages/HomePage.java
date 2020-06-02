package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;
    By searchFieldText = By.id("fe-pa-domain-home-typeahead-input");
    By firstElement = By.id("fe-pa-domain-home-typeahead-item-1");
    By searchButton = By.className("css-1yqt5io");
    By selectedSuburb = By.className("css-i3hekb");
    String suburb;

    public HomePage(WebDriver driver) { this.driver = driver; }

    public void enterIntoSearchField(String searchText) { driver.findElement(searchFieldText).sendKeys(searchText); }

    public String selectFirstOption() {

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(firstElement).click();
        suburb = driver.findElement(selectedSuburb).getText();
        return suburb;

    }

    public void clickSearchButton() { driver.findElement(searchButton).click(); }
}
