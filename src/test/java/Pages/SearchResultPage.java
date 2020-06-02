package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
    WebDriver driver;
    By header = By.className("css-ff9szo");

    public SearchResultPage(WebDriver driver) { this.driver = driver; }

    public String getHeaderText() {

        return driver.findElement(header).getText();
    }
}
