package page;

import AbstractPage.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TShirtPage  extends Page {


    private final By sizeProductLocator = By.xpath("//a[@class = \"sizes-list__item\" and  contains(text(), '46')]");
    private final By checkFunctionLocator = By.xpath("//a[@class = \"w2s-available no-variant-selected\"]");


    public TShirtPage(WebDriver driver, String TShirtUrl) {
        super(driver);
        this.url = TShirtUrl;
    }

    public TShirtPage openPage()  {
        driver.get(url);
        return  this;
    }

    public TShirtPage addSize(){
        clickButtonByXpath(cookiesLocator);
        clickButtonByXpath(sizeProductLocator);
        return this;
    }

    public CheckInTheStorePage openPageCheckOnStoreFunction()    {
        clickButtonByXpath(checkFunctionLocator);
        return new CheckInTheStorePage(driver);
    }
}
