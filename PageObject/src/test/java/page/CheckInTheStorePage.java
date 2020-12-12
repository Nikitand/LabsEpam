package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckInTheStorePage {

    private WebDriver driver;
    static int WAIT_TIMEOUT_SECOND = 25;

    private final By choiceCityLocator = By.name("city");
    private final By moscowCityLocator = By.xpath("//option[@value = \"15011\"]");
    private final By sizeLocator = By.xpath("//a[@class = \"sizes-list__item\" and contains(text(), \"2\")]");
    private final By choiceStoreLocator = By.name("store");
    private final By storeVegasLocator   = By.xpath("//option[@value = \"15011\"]");
    private final By addressStoreLocator   = By.xpath("//span[@class = \"store-info-desc\" and contains(text(),\"МО\")]");

    public CheckInTheStorePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean checkOnStore()
    {
        clickButtonByXpath(choiceCityLocator);
        clickButtonByXpath(moscowCityLocator);
        clickButtonByXpath(sizeLocator);
        clickButtonByXpath(choiceStoreLocator);
        clickButtonByXpath(storeVegasLocator);

        WebElement addressStore = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(addressStoreLocator));

        return !(addressStore.isDisplayed());
    }
    private void clickButtonByXpath(By by) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .click();
    }

}
