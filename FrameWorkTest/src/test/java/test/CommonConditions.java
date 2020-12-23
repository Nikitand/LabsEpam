package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    public String failTerms  = "Хот-дог";
    public String goodTerms  = "Куртка";
    public String failResult = "По запросу «Хот-дог» ничего не найдено";
    public String countProduct = "3";

    @BeforeTest()
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterTest(alwaysRun = true)
    public void close(){
        DriverSingleton.deleteAllCookies();
    }

    @AfterTest(alwaysRun = true)
    public void stopBrowser(){
        DriverSingleton.closeDriver();
    }
}
