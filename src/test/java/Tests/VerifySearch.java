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
        //Setting up driver for firefox tests
        if(browser.equalsIgnoreCase("firefox")) {
            //Update path to gecko driver here
            System.setProperty("webdriver.gecko.driver","/path/to/geckodriver");
            driver = new FirefoxDriver();
        }
        //Setting up driver for Chrome Tests
        else if(browser.equalsIgnoreCase("chrome")) {
            //Update path to chrome driver here
            System.setProperty("webdriver.chrome.driver","/path/to/chromedriver");
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

        //Select the first suggestion when "str" is entered in the search field, then verify that the correct results are displayed
        selectedSuburb = homeActions.selectSuburb();
        Assert.assertTrue(searchResultActions.getHeaderText().contains(selectedSuburb));
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
