import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import package_model.LacostaHomePage;

public class LacostaTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    void Start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 25);
    }
    @Test
    public void searchWithParametrs()
    {
       int searchResult = new LacostaHomePage(driver)
               .openPage()
               .searchForTerms("КУРТКА")
               .addParametrs()
               .countNumberOfSearchResult();

                Assert.assertTrue("search result are empty", searchResult>0);

    }


    @AfterTest(alwaysRun = true)
    void Finish()
    {
        driver.quit();
    }
}