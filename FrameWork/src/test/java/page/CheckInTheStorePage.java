package page;

import AbstractPage.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckInTheStorePage  extends Page {

    private final By choiceCityLocator = By.name("city");
    private final By moscowCityLocator = By.xpath("//option[@value = \"15011\"]");
    private final By sizeLocator = By.xpath("//a[@class = \"sizes-list__item\" and contains(text(), \"2\")]");
    private final By choiceStoreLocator = By.xpath("//select[@name = \"store\"]");
    private final By storeVegasLocator   = By.xpath("//option[@value = \"3\"]");
    private final By addressStoreLocator   = By.xpath("//span[@class = \"store-info-desc\" and contains(text(),\"МО\")]");

    public CheckInTheStorePage(WebDriver driver)    {
        super(driver);
    }

    public Boolean checkOnStore()    {
        clickButtonByXpath(choiceCityLocator);
        clickButtonByXpath(moscowCityLocator);
        clickButtonByXpath(sizeLocator);
        clickButtonByXpath(choiceStoreLocator);
        clickButtonByXpath(storeVegasLocator);
        WebElement addressStore = new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(addressStoreLocator));
        return !(addressStore.isDisplayed());
    }
}