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
    private final By moscowCityLocator = By.xpath("//*[@id=\"vee-city\"]/option[2]");
    private final By sizeLocator = By.xpath("//*[@id=\"stepshipping\"]/div[1]//div[2]/div/div/a[1]");
    private final By choiceStoreLocator = By.name("store");
    private final By storeVegasLocator   = By.xpath("//*[@id=\"vee-store\"]/option[6]");
    private final By addressStoreLocator   = By.xpath("//*[@id=\"checkout-shipping-form\"]/div/p[1]/span");
    private final By cookiesLocator = By.id("cookie-policy");

    public CheckInTheStorePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckInTheStorePage addParametrs()
    {
        clickButtonByXpath(cookiesLocator);
        WebElement choiceSize = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(sizeProductLocator));
        choiceSize.click();
        return this;
    }

    public CheckInTheStorePage openPageCheckOnStoreFunction()
    {
        WebElement openCheckFunction = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(checkFunctionLocator));
        openCheckFunction.click();
        return new CheckInTheStorePage(driver);
    }

    public Boolean checkOnStore()
    {
        WebElement choiceCity = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(choiceCityLocator));
        choiceCity.click();
        WebElement choiceMoscowCity = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(moscowCityLocator));
        choiceMoscowCity.click();
        WebElement choiceSize = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(sizeLocator));
        choiceSize.click();
        WebElement choiceStore = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(choiceStoreLocator));
        choiceStore.click();
        WebElement choiceStoreVegas = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(storeVegasLocator));
        choiceStoreVegas.click();
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
