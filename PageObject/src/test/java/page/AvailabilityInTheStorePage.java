package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AvailabilityInTheStorePage {
    private WebDriver driver;
    static int WAIT_TIMEOUT_SECOND = 15;
    private  static final String PRODUCT_URL  = "https://lacoste.ru/catalog/novye-postupleniya-muzhchiny/futbolka_lacoste_367_color_031/";

    private final By sizeProductLocator = By.xpath("//*[@id=\"js-sizes\"]/div[2]/a[1]");

    private final By checkFunctionLocator = By.xpath("//*[@id=\"js-sku-product\"]/div/section[1]/div/div/div[4]/div/div[4]/div[2]/a/button/span");

    private final By choiceCityLocator = By.name("city");

    private final By moscowCityLocator = By.xpath("//*[@id=\"vee-city\"]/option[2]");

    private final By sizeLocator = By.xpath("//*[@id=\"stepshipping\"]/div[1]//div[2]/div/div/a[1]");

    private final By choiceStoreLocator = By.name("store");

    private final By storeVegasLocator   = By.xpath("//*[@id=\"vee-store\"]/option[6]");

    private final By addressStoreLocator   = By.xpath("//*[@id=\"checkout-shipping-form\"]/div/p[1]/span");


    public AvailabilityInTheStorePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public  AvailabilityInTheStorePage openPage()
    {
        driver.get(PRODUCT_URL);
        driver.manage().window().maximize();
        return  this;
    }

    public  AvailabilityInTheStorePage addParametrs()
    {
        WebElement choiceSize = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(sizeProductLocator));
        choiceSize.click();
        return this;
    }

    public  AvailabilityInTheStorePage openPageCheckOnStoreFunction()
    {
        WebElement openCheckFunction = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.presenceOfElementLocated(checkFunctionLocator));
        openCheckFunction.click();
        return new AvailabilityInTheStorePage(driver);
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


}
