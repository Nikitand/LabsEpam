package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FutbolkaPage {

    private final  static  int  TIME_OUT_SECONDS =  15  ;
    private WebDriver driver;
    private  String url;
    private final By sizeProductLocator = By.xpath("//a[@class = \"sizes-list__item\" and  contains(text(), '46')]");
    private final By checkFunctionLocator = By.xpath("//span[@class = \"w2s-available-label\"]");
    private final By cookiesLocator = By.id("cookie-policy");

    public FutbolkaPage(WebDriver driver, String FutbolkaUrl) {
        this.url = FutbolkaUrl;
        this.driver = driver;
    }

    public FutbolkaPage openPage()
    {
        driver.get(url);
        return  this;
    }

    public FutbolkaPage addSize(){
        clickButtonByXpath(sizeProductLocator);
        clickButtonByXpath(cookiesLocator);
        return this;
    }

    public CheckInTheStorePage openPageCheckOnStoreFunction()
    {
        clickButtonByXpath(checkFunctionLocator);
        return new CheckInTheStorePage(driver);
    }

    private void clickButtonByXpath(By by) {
        new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .click();
    }
}
