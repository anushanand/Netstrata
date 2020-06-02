package Tests;

import Actions.HomeActions;
import Actions.SearchResultActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class VerifySearch {
    HomeActions homeActions;
    SearchResultActions searchResultActions;
    WebDriver driver;
    String selectedSuburb;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver","/Users/anushaanand/IdeaProjects/netstrata/geckodriver");
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver","/Users/anushaanand/IdeaProjects/netstrata/chromedriver");
            driver = new ChromeDriver();
        }
        else {
            throw new Exception("Unknown Browser specified");
        }
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.domain.com.au/");
    }

    @Test
    public void verifySearchSteps(){
        homeActions = new HomeActions(driver);
        searchResultActions = new SearchResultActions(driver);

        selectedSuburb = homeActions.selectSuburb();
        Assert.assertTrue(searchResultActions.getHeaderText().contains(selectedSuburb));
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
