package test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.LacostaHomePage;

import java.io.File;
import java.io.IOException;

public class LacostaTest {
    WebDriver driver;
    WebDriverWait wait;
    private static ChromeDriverService service;
    @BeforeTest
    void Start() throws IOException {
        driver = new ChromeDriver();
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:\\driver\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
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
        service.stop();
    }
}