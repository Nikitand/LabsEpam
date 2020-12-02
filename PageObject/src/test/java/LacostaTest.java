import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import package_model.LacostaHomePage;

import java.util.concurrent.TimeUnit;

public class LacostaTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    void Start() {
        driver = new ChromeDriver();

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